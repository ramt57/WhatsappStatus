package com.ramt57.whatsappstatus.ui.main

import android.graphics.Bitmap
import android.os.Bundle
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator
import com.nostra13.universalimageloader.core.DisplayImageOptions
import com.nostra13.universalimageloader.core.ImageLoader
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration
import com.nostra13.universalimageloader.core.assist.FailReason
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener
import com.ramt57.whatsappstatus.R


class ViewPagerAddsFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: Int = 0
    private var mParam2: String? = null

    //Declaration of View Present in layout file
    lateinit var iv_adds: ImageView
    lateinit var pb_addsprogressBar: ProgressBar

   override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getArguments() != null) {
            mParam1 = getArguments()!!.getInt(ARG_PARAM1)
            mParam2 = getArguments()!!.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_view_pager_adds, container, false)



        iv_adds = view.findViewById(R.id.iv_adds) as ImageView
        pb_addsprogressBar = view.findViewById(R.id.pb_addsprogressBar) as ProgressBar

        val config = ImageLoaderConfiguration.Builder(getContext())
            // You can pass your own memory cache implementation
            .diskCacheFileNameGenerator(HashCodeFileNameGenerator())
            .build()

        val options = DisplayImageOptions.Builder()
            .displayer(RoundedBitmapDisplayer(10))//rounded corner bitmap
            .cacheInMemory(true)
            .cacheOnDisk(true)
            .build()

        val imageLoader = ImageLoader.getInstance()
        imageLoader.init(config)
        imageLoader.setDefaultLoadingListener(object : ImageLoadingListener {
            override fun onLoadingStarted(imageUri: String, view: View) {
                pb_addsprogressBar.setVisibility(View.VISIBLE)//when loading started progress bar will Visible
            }

            override fun onLoadingFailed(imageUri: String, view: View, failReason: FailReason) {

            }

            override fun onLoadingComplete(imageUri: String, view: View, loadedImage: Bitmap) {
                pb_addsprogressBar.setVisibility(View.GONE)//when loading Completed progress bar will Disappear
                pb_addsprogressBar.destroyDrawingCache()
            }

            override fun onLoadingCancelled(imageUri: String, view: View) {}
        })

        imageLoader.displayImage(mParam2, iv_adds, options)//set the fetched image to imageview with round corner


        // iv_adds.setImageResource(mParam1);

        return view
    }

    companion object {

        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ViewPagerAddsFragment.
         */
        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: Int, param2: String): ViewPagerAddsFragment {
            val fragment = ViewPagerAddsFragment()
            val args = Bundle()
            args.putInt(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.setArguments(args)
            return fragment
        }
    }

}// Required empty public constructor