package com.azp.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azp.newsapp.R
import com.azp.newsapp.model1.Meal

import com.azp.newsapp.model2.Category
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_home.view.*

class RandomAdapter(var mealList: List<Meal> = ArrayList<Meal>()) :
    RecyclerView.Adapter<RandomAdapter.RandomViewHolder>() {

    var mClickListener: ClickListener? = null

    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener = clickListener
    }

    inner class RandomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        lateinit var meal: Meal

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(meal: Meal) {
            Picasso.get().load(meal.strMealThumb).placeholder(R.drawable.ic_launcher_background)
                .into(itemView.imgRandom)
            itemView.txtRandom.text = meal.strMeal

        }

        override fun onClick(view: View?) {
            mClickListener?.onClcik(meal)
        }
    }

    fun updateMeal(articleList: List<Meal>) {
        this.mealList = articleList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RandomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_home, parent, false)
        return RandomViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mealList.size
    }

    override fun onBindViewHolder(holder: RandomViewHolder, position: Int) {
        holder.bind(mealList.get(position))
    }

    interface ClickListener {
        fun onClcik(meal: Meal)
    }

}