package com.ramt57.whatsappstatus.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.ramt57.whatsappstatus.R.mipmap.ic_launcher
import androidx.fragment.app.FragmentStatePagerAdapter
import com.ramt57.whatsappstatus.R
import com.ramt57.whatsappstatus.ui.main.ViewPagerAddsFragment


public class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        var fragment = ViewPagerAddsFragment.newInstance(R.mipmap.ic_launcher, "Intialize")

        when (position) {

            0 -> fragment = ViewPagerAddsFragment.newInstance(
                R.mipmap.ic_launcher,
                "http://imgs.abduzeedo.com/files/paul0v2/footwear-ads/ADIDAS_TREE.preview.jpg"
            )
            1 -> fragment = ViewPagerAddsFragment.newInstance(
                R.mipmap.ic_launcher,
                "http://www.sourceraven.com/wp-content/uploads/2014/01/creative1.png"
            )
            2 -> fragment = ViewPagerAddsFragment.newInstance(
                R.mipmap.ic_launcher,
                "http://pixelantix.com/img/slider/Creative-Design-Business.jpg"
            )
            else -> fragment = ViewPagerAddsFragment.newInstance(
                R.mipmap.ic_launcher,
                "http://4.bp.blogspot.com/-vSfob76kWOc/VBmof0C800I/AAAAAAAAEBw/9LNwNyViXa8/s1600/funadress%2Bcreative%2Bdrawings%2B9.jpg"
            )
        }
        return fragment
    }

    override fun getCount(): Int {
        return 4
    }
}
