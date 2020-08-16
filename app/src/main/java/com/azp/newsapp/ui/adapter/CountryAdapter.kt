package com.azp.newsapp.ui.adapter



import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azp.newsapp.R

import com.azp.newsapp.model2.Category
import com.azp.newsapp.model4.Meal
import kotlinx.android.synthetic.main.item_country.view.*

class CountryAdapter(var countryList: List<Meal> = ArrayList<Meal>()) :
    RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {

    var mClickListener: ClickListener? = null

    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener = clickListener
    }

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        lateinit var meal: Meal

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(meal: Meal) {
            itemView.txtCountry2.text = meal.strArea


        }

        override fun onClick(view: View?) {
            mClickListener?.onClcik(meal)
        }
    }

    fun updateCountry(articleList: List<Meal>) {
        this.countryList = articleList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countryList.get(position))
    }

    interface ClickListener {
        fun onClcik(meal: Meal)
    }

}