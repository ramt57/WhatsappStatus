package com.ramt57.whatsappstatus.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
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
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: ViewPagerAdapter
    lateinit var mAdView : AdView
    private lateinit var list:ArrayList<String>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.detail_fragment, container, false)
        viewPager=view.findViewById(R.id.viewPager)
        adapter=ViewPagerAdapter(fragmentManager!!)
        list=ArrayList()
        adapter.setlistData(list)
        viewPager.offscreenPageLimit=2
        viewPager.setPageTransformer(false,DepthPageTransformer())
        viewPager.adapter=adapter
        setupads(view)
        return view
    }
    /*todo implement in utils*/
    private fun setupads(view: View?) {
        /*ads code*/
//        mAdView = view!!.findViewById(R.id.view2)
//        val adRequest = AdRequest.Builder().build()
//        mAdView.loadAd(adRequest)
//        mAdView.adListener = object: AdListener() {
//            override fun onAdLoaded() {
//                // Code to be executed when an ad finishes loading.
//                mAdView.visibility=View.VISIBLE
//            }
//        }
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getQuotesLiveData(viewModel.getSingleDocQuotes("Best"))
        viewModel.getQuoteList().observe(this, Observer {
            Log.w("TAG", it[5]+" data")
            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        // TODO: Use the ViewModel
    }

}
