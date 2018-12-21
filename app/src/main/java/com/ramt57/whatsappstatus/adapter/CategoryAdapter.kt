package com.ramt57.whatsappstatus.adapter

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ramt57.whatsappstatus.R
import android.view.LayoutInflater
import android.widget.Toast
import androidx.cardview.widget.CardView
import kotlin.random.Random


class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    var list = arrayOf(
        R.color.lightblue,
        R.color.lightest,
        R.color.lightgreen,
        R.color.lightpink,
        R.color.lightorange,
        R.color.lightvoilet,
        R.color.voilet
    )
    companion object {
        var random = Random(24232)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.category_card, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        Log.w("TAG",getRandomColor().toString()+" sd"
        )

       holder.cardView.setCardBackgroundColor(list[3])
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var keywordtitle: TextView
        var keywordicon: ImageView
        var cardView:CardView
        init {
            cardView=itemView.findViewById(R.id.card_view)
            keywordtitle = itemView.findViewById(R.id.text)
            keywordicon = itemView.findViewById(R.id.icon)
        }
    }

    fun getRandomColor(): Int {
        return random.nextInt(7)
    }
}