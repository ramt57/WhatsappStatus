package com.ramt57.whatsappstatus.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.ramt57.whatsappstatus.R
import com.ramt57.whatsappstatus.adapter.CategoryAdapter
import com.ramt57.whatsappstatus.repository.CloudRepository
import kotlin.collections.ArrayList
import com.google.android.material.appbar.AppBarLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.ramt57.whatsappstatus.adapter.ViewPagerAdapter


class MainFragment : androidx.fragment.app.Fragment() {

    companion object {
        fun newInstance() = MainFragment()

    }

    private lateinit var viewModel: MainViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var categoryAdapter: CategoryAdapter
    private var vp_adds: ViewPager? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        var view = inflater.inflate(R.layout.main_fragment, container, false)
        setup(view)
        return view
    }

    private fun setup(view: View?) {
        recyclerView=view!!.findViewById(R.id.recyclerView)
        vp_adds=view.findViewById(R.id.viewpager)
        //setting adpater in viewpager
        vp_adds!!.adapter=ViewPagerAdapter(fragmentManager!!)

        //margin to dispaly two page at one time like GoogleplayStore
        vp_adds!!.setPageMargin(12)
        vp_adds!!.setDrawingCacheEnabled(true);

        recyclerView.layoutManager=LinearLayoutManager(view.context)
        categoryAdapter=CategoryAdapter()
        initCollapsingToolbar(view)
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

    /**
     *
     * Will show and hide the toolbar title on scroll
     */
    private fun initCollapsingToolbar(view: View?) {
        var toolbar=view!!.findViewById<Toolbar>(R.id.toolbar)
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
        var collapsingToolbar=view.findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar)
        collapsingToolbar!!.title=""
        val appBarLayout = view.findViewById(R.id.appbar) as AppBarLayout
        appBarLayout.setExpanded(true)

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(object : AppBarLayout.OnOffsetChangedListener {
            internal var isShow = false
            internal var scrollRange = -1

            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.title=resources.getString(R.string.app_name)
                    isShow = true
                } else if (isShow) {
                    collapsingToolbar.title=""
                    isShow = false
                }
            }
        })
    }
}
