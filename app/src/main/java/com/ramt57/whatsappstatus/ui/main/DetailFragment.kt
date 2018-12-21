package com.ramt57.whatsappstatus.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager

import com.ramt57.whatsappstatus.R
import com.ramt57.whatsappstatus.utils.CustomViewPager

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }
    private lateinit var viewPager: CustomViewPager
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.detail_fragment, container, false)
        viewPager=view.findViewById(R.id.viewPager)
        viewPager.offscreenPageLimit=2
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
