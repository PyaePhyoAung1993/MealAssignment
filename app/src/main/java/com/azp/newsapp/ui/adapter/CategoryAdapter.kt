package com.azp.newsapp.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azp.newsapp.R

import com.azp.newsapp.model2.Category
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_categories.view.*

class CategoryAdapter(var categoryLIst: List<Category> = ArrayList<Category>()) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    var mClickListener: ClickListener? = null

    fun setOnClickListener(clickListener: ClickListener){
        this.mClickListener = clickListener
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        lateinit var category: Category

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(category: Category) {
            Picasso.get().load(category.strCategoryThumb).placeholder(R.drawable.ic_launcher_background)
                .into(itemView.imgCategory)
            itemView.txtCategory.text = category.strCategory

        }

        override fun onClick(view: View?) {
            mClickListener?.onClcik(category)
        }
    }

    fun updateCategory(articleList: List<Category>) {
        this.categoryLIst = articleList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_categories, parent, false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryLIst.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryLIst.get(position))
    }

    interface ClickListener {
        fun onClcik(category: Category)
    }

}