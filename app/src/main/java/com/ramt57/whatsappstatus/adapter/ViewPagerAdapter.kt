package com.ramt57.whatsappstatus.adapter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ramt57.whatsappstatus.model.Quotes
import com.ramt57.whatsappstatus.ui.main.CardFragment

class ViewPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    private var list = ArrayList<String>()

    fun setlistData(templist:ArrayList<String>) {
        list=templist
    }

    override fun getItem(position: Int): Fragment {
        var cardFragment= CardFragment()
        Log.w("LOGTAG",list[position]+" d")
        var bundle=Bundle()
        bundle.putString("quotes",list[position])
        bundle.putInt("page",position+1)
        cardFragment.arguments=bundle
        return cardFragment
    }

    override fun getCount(): Int {
        return list.size
    }
}