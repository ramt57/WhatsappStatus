package com.ramt57.whatsappstatus.repository

import android.content.Context
import android.util.Log
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class CloudRepository private constructor(ctx: Context) {
    private val BASE_COLLECTION: String = "category"
    private val LIST_KEY = "quotes"
    private var listner: CloudRepositoryCallBack? = null
    var firestoreInstance: FirebaseFirestore? = null

    init {
        firestoreInstance = FirebaseFirestore.getInstance()
    }

    companion object {
        private var INSTANCE: CloudRepository? = null
        fun getInstance(ctx: Context): CloudRepository {
            return INSTANCE ?: CloudRepository(ctx)
        }
    }

    private fun getSingleDocument(key: String): DocumentReference? {
        var doc = firestoreInstance?.collection(BASE_COLLECTION)?.document(key)
        return doc
    }

    fun getMultiDocument(): List<DocumentReference>? {
        Log.w("DATA", "eqt d")
        firestoreInstance?.collection(BASE_COLLECTION)?.get()?.addOnCompleteListener {
            if (it.isSuccessful) {
                /*retrive all document*/
                Log.w("DATA", "eqt ")
                var documentlist = ArrayList<DocumentReference>()
                for (document in it.result!!) {
                    documentlist.add(document.reference)
                }
                if (listner != null)
                    listner!!.getCloudData(documentlist)
                else
                    Log.w("DATA", "eqt 12")

            } else {
                /*handle failure*/
                Log.w("DATA", "eqtl ")
            }
        }
        return null
    }

    fun getDocumentContent(documentReference: DocumentReference) {
        documentReference.get().addOnCompleteListener {
            if (it.isSuccessful) {
                var list = it.result?.data?.get(LIST_KEY) as List<*>
                Log.w("TAG", "" + list[3])
            } else {
                /*handle error*/
            }
        }
    }

    fun setCloudListener(tempListner: CloudRepositoryCallBack) {
        this.listner = tempListner
    }

    public interface CloudRepositoryCallBack {
        fun getCloudData(documentlist: ArrayList<DocumentReference>)
    }
}