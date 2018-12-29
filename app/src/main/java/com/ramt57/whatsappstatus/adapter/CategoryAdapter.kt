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
import com.bumptech.glide.Glide
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import kotlin.random.Random
import com.google.firebase.storage.StorageReference


class CategoryAdapter(temp: ArrayList<String>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {
    var listitems: ArrayList<String>
    var storage = FirebaseStorage.getInstance("gs://test-99d16.appspot.com/")
    val storageRef = storage.reference

    init {
        listitems = temp
    }

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
        return listitems.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        Log.w("TAG", getRandomColor().toString() + " sd")
        holder.keywordtitle.text = listitems[position]
        var spaceRef = storageRef.child("images").child(listitems[position].toLowerCase())
        spaceRef.downloadUrl.addOnCompleteListener {
            if(it.isSuccessful){
                Log.w("TAG","url:- "+it.result)
            }
        }
        holder.cardView.setCardBackgroundColor(list[getRandomColor()])
    }

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var keywordtitle: TextView
        var keywordicon: ImageView
        var cardView: CardView

        init {
            cardView = itemView.findViewById(R.id.card_view)
            keywordtitle = itemView.findViewById(R.id.text)
            keywordicon = itemView.findViewById(R.id.icon)
        }
    }

    fun getRandomColor(): Int {
        return random.nextInt(7)
    }
}