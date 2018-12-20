package com.ramt57.whatsappstatus.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ramt57.whatsappstatus.R
import android.view.LayoutInflater




class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.category_card, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return  10
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {

    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var keywordtitle: TextView
        var keywordicon: ImageView

        init {
            keywordtitle = itemView.findViewById(R.id.textView4)
            keywordicon = itemView.findViewById(R.id.imageView)
        }
    }
}