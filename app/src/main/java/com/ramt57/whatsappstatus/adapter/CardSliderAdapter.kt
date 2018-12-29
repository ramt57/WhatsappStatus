package com.ramt57.whatsappstatus.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.firebase.firestore.model.value.IntegerValue
import com.ramt57.whatsappstatus.R
import kotlinx.android.synthetic.main.card_layout.view.*

class CardSliderAdapter(templist: ArrayList<String>) : RecyclerView.Adapter<CardSliderAdapter.CardViewHolder>() {
    var list: ArrayList<String>

    init {
        list = templist
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return CardViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.quotes.text = list[position]
        holder.page_no.text = (position+1).toString()+""
        val adRequest = AdRequest.Builder().build()
//        holder.adview.loadAd(adRequest)
    }

    class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var quotes: TextView
        var page_no: TextView
//        var adview: AdView

        init {
            quotes = itemView.findViewById(R.id.textView)
            page_no = itemView.findViewById(R.id.textView4)
//            adview = itemView.findViewById(R.id.adView)
//            adview.adListener=object :AdListener(){
//                override fun onAdLoaded() {
//                 adview.visibility=View.VISIBLE
//                }
//            }
        }
    }
}