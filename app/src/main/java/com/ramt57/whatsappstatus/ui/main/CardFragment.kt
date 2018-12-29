package com.ramt57.whatsappstatus.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.PixelCopy
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.material.button.MaterialButton
import com.ramt57.whatsappstatus.R
import kotlinx.android.synthetic.main.card_layout.*

class CardFragment : Fragment() {
    lateinit var textView: TextView
    lateinit var copy: MaterialButton
    lateinit var share: ImageView
    lateinit var pageumber: TextView

    companion object {
        private var quotes: String? = null
        private var page: Int? = null
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.card_layout, container, false)
        initviews(view)
        setupAds(view)
        setupData()
        return view
    }

    private fun setupData() {
        var string = arguments?.getString("quotes")
        var page = arguments?.getInt("page")
        textView.text = string
        pageumber.text = page.toString()
    }

    private fun initviews(view: View?) {
        textView = view!!.findViewById(R.id.textView)
        copy = view!!.findViewById(R.id.textView2)
        share = view.findViewById(R.id.imageView3)
        pageumber = view.findViewById(R.id.textView4)
    }

    private fun setupAds(view: View?) {
        val adRequest = AdRequest.Builder().build()
//        val mAdView = view!!.findViewById<AdView>(R.id.adView)
//        mAdView.loadAd(adRequest)
//        mAdView.adListener = object : AdListener() {
//            override fun onAdLoaded() {
//                // Code to be executed when an ad finishes loading.
//                mAdView.visibility = View.VISIBLE
//            }
//        }
    }
}