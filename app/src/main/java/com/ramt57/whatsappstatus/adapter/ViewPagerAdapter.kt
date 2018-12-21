package com.ramt57.whatsappstatus.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ramt57.whatsappstatus.ui.main.CardFragment

class ViewPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
       return CardFragment()
    }

    override fun getCount(): Int {
       return 15
    }
}