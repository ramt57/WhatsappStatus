package com.ramt57.whatsappstatus.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.ramt57.whatsappstatus.R
import com.ramt57.whatsappstatus.adapter.CategoryAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView


class MainFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = MainFragment()

    }
    lateinit var mAdView : AdView
    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view = inflater.inflate(R.layout.main_fragment, container, false)
        setupads(view)
        setup(view)
        return view
    }

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

    private fun setup(view: View?) {
        recyclerView=view!!.findViewById(R.id.recyclerview)
        recyclerView.layoutManager=GridLayoutManager(view.context,2)
        categoryAdapter=CategoryAdapter(ArrayList())
        recyclerView.adapter=categoryAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getDocumentLiveData()
        viewModel.getQuotesLiveData(viewModel.getSingleDocQuotes("Best"))
        viewModel.getDocList().observe(this, Observer {
            Log.w("TAG", it[5].toString() + "")
        })
        viewModel.getQuoteList().observe(this, Observer {
            Log.w("TAG", it[5])
        })
    }
}
