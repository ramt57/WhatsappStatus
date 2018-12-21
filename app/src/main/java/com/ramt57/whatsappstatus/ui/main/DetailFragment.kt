package com.ramt57.whatsappstatus.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.viewpager.widget.ViewPager
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

import com.ramt57.whatsappstatus.R
import com.ramt57.whatsappstatus.adapter.ViewPagerAdapter
import com.ramt57.whatsappstatus.utils.CustomViewPager
import com.ramt57.whatsappstatus.utils.DepthPageTransformer

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }
    private lateinit var viewPager: CustomViewPager
    private lateinit var viewModel: DetailViewModel
    private lateinit var adapter: ViewPagerAdapter
    lateinit var mAdView : AdView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.detail_fragment, container, false)
        viewPager=view.findViewById(R.id.viewPager)
        adapter=ViewPagerAdapter(fragmentManager!!)
        viewPager.offscreenPageLimit=2
        viewPager.setPageTransformer(true,DepthPageTransformer())
        viewPager.adapter=adapter
        setupads(view)
        return view
    }
    /*todo implement in utils*/
    private fun setupads(view: View?) {
        /*ads code*/
        mAdView = view!!.findViewById(R.id.view2)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
        mAdView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                mAdView.visibility=View.VISIBLE
            }
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
