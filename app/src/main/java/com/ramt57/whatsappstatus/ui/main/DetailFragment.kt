package com.ramt57.whatsappstatus.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView

import com.ramt57.whatsappstatus.R
import com.ramt57.whatsappstatus.adapter.CardSliderAdapter
import com.ramt57.whatsappstatus.adapter.CategoryAdapter
import com.ramt57.whatsappstatus.adapter.ViewPagerAdapter
import com.ramt57.whatsappstatus.utils.CustomLayoutManager
import com.ramt57.whatsappstatus.utils.CustomViewPager
import com.ramt57.whatsappstatus.utils.DepthPageTransformer

class DetailFragment : Fragment() {
    companion object {
        fun newInstance() = DetailFragment()
    }

//    private lateinit var recyclerView: RecyclerView
    private lateinit var verticalList: RecyclerView
    private lateinit var viewModel: MainViewModel
//    private lateinit var adapter: CardSliderAdapter
    private lateinit var categoryAdapter: CategoryAdapter
    lateinit var mAdView: AdView
    private var list = ArrayList<String>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.detail_fragment, container, false)
//        recyclerView = view.findViewById(R.id.recyclerview)
        verticalList=view.findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = CustomLayoutManager(view.context,RecyclerView.HORIZONTAL,false)
        verticalList.layoutManager=GridLayoutManager(view.context,2)
//        adapter = CardSliderAdapter(list)
        categoryAdapter=CategoryAdapter(list)
//        recyclerView.adapter = adapter
        verticalList.adapter=categoryAdapter
        setupViews()
        setupads(view)
        return view
    }

    private fun setupads(view: View?) {
        var adRequest=AdRequest.Builder().build()
        mAdView=view!!.findViewById(R.id.view2)
        mAdView.loadAd(adRequest)
        mAdView.adListener=object :AdListener(){
            override fun onAdLoaded() {
                mAdView.visibility=View.VISIBLE
//                recyclerView.smoothScrollToPosition(20)
            }
        }
    }

    /*todo implement in utils*/
    private fun setupViews() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getDocumentLiveData()
        viewModel.getDocList().observe(this, Observer {
            Log.w("TAG", it[5].id + " data")
            for (doc in it){
                list.add(doc.id)
            }
            categoryAdapter.notifyDataSetChanged()
        })
    }
}
