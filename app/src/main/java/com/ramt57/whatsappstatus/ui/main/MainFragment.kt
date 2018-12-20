package com.ramt57.whatsappstatus.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.ramt57.whatsappstatus.R
import com.ramt57.whatsappstatus.repository.CloudRepository
import kotlin.collections.ArrayList

class MainFragment : androidx.fragment.app.Fragment() {
    private lateinit var instancr:CloudRepository


    var firebaseFirestore = FirebaseFirestore.getInstance()

    companion object {
        fun newInstance() = MainFragment()

    }

    private lateinit var viewModel:MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.getDocumentLiveData()
        viewModel.getQuotesLiveData(viewModel.getSingleDocQuotes("Best"))
        viewModel.getDocList().observe(this, Observer {
            Log.w("TAG",it[5].toString()+"")
        })
        viewModel.getQuoteList().observe(this, Observer {
            Log.w("TAG",it[5])
        })
    }
}
