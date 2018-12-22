package com.ramt57.whatsappstatus.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager
import java.util.jar.Attributes


class CustomViewPager(context: Context, attributes: AttributeSet?) : ViewPager(context, attributes) {
    constructor(context: Context) : this(context, attributes = null)

    //    override fun getChildDrawingOrder(childCount: Int, i: Int): Int {
//        return if (i == childCount - 1) {
//            currentItem
//        } else {
//            i
//        }
//    }
     override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        var heightMeasureSpec = heightMeasureSpec

        var height = 0
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            child.measure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
            val h = child.measuredHeight
            if (h > height) height = h
        }

        heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(height, View.MeasureSpec.EXACTLY)

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}