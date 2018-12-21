package com.ramt57.whatsappstatus.utils

import android.content.Context
import androidx.viewpager.widget.ViewPager


class CustomViewPager(context: Context): ViewPager(context) {
    override fun getChildDrawingOrder(childCount: Int, i: Int): Int {
        return if (i == childCount - 1) {
            currentItem
        } else {
            if (i >= currentItem) i + 1 else i
        }
    }
}