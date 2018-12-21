package com.ramt57.whatsappstatus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.android.gms.ads.MobileAds
import com.ramt57.whatsappstatus.ui.main.MainFragment
import com.ramt57.whatsappstatus.ui.main.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        MobileAds.initialize(this, resources.getString(R.string.app_ads_id))
//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.container, MainFragment.newInstance())
//                .commitNow()
//        }
        navController=Navigation.findNavController(this,R.id.fragment)
    }

}
