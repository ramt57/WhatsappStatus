package com.ramt57.whatsappstatus.utils

import androidx.core.view.ViewCompat
import android.view.View
import androidx.viewpager.widget.ViewPager


class DepthPageTransformer : ViewPager.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        val pageWidth = view.width

        if (position < -1) {
            view.alpha = MIN_FADE
        } else if (position < 0) {
            view.alpha = 1 + position * (1 - MIN_FADE)
            view.translationX = (-pageWidth).toFloat() * MAX_SCALE * position
            ViewCompat.setTranslationZ(view, position)
            val scaleFactor = MIN_SCALE + (MAX_SCALE - MIN_SCALE) * (1 - Math.abs(position))
            view.scaleX = scaleFactor
            view.scaleY = scaleFactor
        } else if (position == 0f) {
            view.alpha = 1.0f
            view.translationX = 0f
            view.scaleX = MAX_SCALE
            ViewCompat.setTranslationZ(view, 0f)
            view.scaleY = MAX_SCALE
        } else if (position <= 1) {
            ViewCompat.setTranslationZ(view, -position)
            view.alpha = 1 - position * (1 - MIN_FADE)
            view.translationX = pageWidth.toFloat() * MAX_SCALE * -position

            val scaleFactor = MIN_SCALE + (MAX_SCALE - MIN_SCALE) * (1 - Math.abs(position))
            view.scaleX = scaleFactor
            view.scaleY = scaleFactor
        } else {
            view.alpha = MIN_FADE
        }
    }

    companion object {
        private val MIN_SCALE = 0.5f
        private val MAX_SCALE = 0.8f
        private val MIN_FADE = 0.2f
    }
}