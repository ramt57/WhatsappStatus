package com.ramt57.whatsappstatus.ui.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ramt57.whatsappstatus.repository.CloudRepository
import androidx.lifecycle.LiveData
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import com.google.firebase.firestore.DocumentReference


class MainViewModel: ViewModel(){
    private  var  liveData:CloudRepository = CloudRepository()
    private   var listDocument=MutableLiveData<List<DocumentReference>>()
    private var listQuotes= MutableLiveData<List<String>>()
    fun getDocumentLiveData() {
        if(listDocument.value!=null){
            Log.w("TAG","from viewmodel")
            return
        }
        listDocument= liveData.getMultiDocument() as MutableLiveData<List<DocumentReference>>
    }
    fun getQuotesLiveData(documentReference: DocumentReference){
        if(listQuotes.value!=null){
            Log.w("TAG","from viewmodel")
            return
        }
        listQuotes= liveData.getDocumentContent(documentReference) as MutableLiveData<List<String>>
    }
    fun getDocList(): LiveData<List<DocumentReference>> {
        return this.listDocument
    }
    fun getQuoteList():LiveData<List<String>>{
        return this.listQuotes
    }
    fun getSingleDocQuotes(key:String):DocumentReference{
       return liveData.getSingleDocument(key)
    }
}
