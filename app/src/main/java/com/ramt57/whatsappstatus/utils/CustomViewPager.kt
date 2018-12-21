package com.ramt57.whatsappstatus.utils

import android.content.Context
import android.util.AttributeSet
import androidx.viewpager.widget.ViewPager
import java.util.jar.Attributes


class CustomViewPager(context: Context,attributes:AttributeSet?): ViewPager(context,attributes) {
    constructor(context: Context) : this(context,attributes= null)
//    override fun getChildDrawingOrder(childCount: Int, i: Int): Int {
//        return if (i == childCount - 1) {
//            currentItem
//        } else {
//            i
//        }
//    }
}