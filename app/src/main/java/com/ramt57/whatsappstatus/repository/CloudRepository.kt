package com.ramt57.whatsappstatus.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import androidx.lifecycle.MutableLiveData


class CloudRepository {
    private val BASE_COLLECTION: String = "category"
    private val LIST_KEY = "quotes"
    var firestoreInstance: FirebaseFirestore = FirebaseFirestore.getInstance()

    fun getSingleDocument(key: String): DocumentReference {
        return firestoreInstance.collection(BASE_COLLECTION).document(key)
    }

    fun getMultiDocument(): LiveData<List<DocumentReference>> {
        Log.w("TAG", "from firestore call")
        val result = MutableLiveData<List<DocumentReference>>()
        firestoreInstance.collection(BASE_COLLECTION).get().addOnCompleteListener {
            if (it.isSuccessful) {
                /*retrive all document*/
                Log.w("DATA", "eqt ")
                val documentlist = ArrayList<DocumentReference>()
                for (document in it.result!!) {
                    documentlist.add(document.reference)
                }
                result.postValue(documentlist)
            } else {
                /*handle failure*/
                Log.w("DATA", "eqtl ")
            }
        }
        return result
    }

    fun getDocumentContent(documentReference: DocumentReference): LiveData<List<*>> {
        val result = MutableLiveData<List<*>>()
        documentReference.get().addOnCompleteListener {
            if (it.isSuccessful) {
                var list = it.result?.data?.get(LIST_KEY) as List<*>
                result.postValue(list)
            } else {
                /*handle error*/
            }
        }
        return result
    }

}