package com.ramt57.whatsappstatus.repository

import android.content.Context
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

class CloudRepository private constructor(ctx:Context) {
    private val BASE_COLLECTION:String="category"
    var firestoreInstance:FirebaseFirestore?=null
    companion object {
        var INSTANCE:CloudRepository? = null
        fun getInstance(ctx: Context){
            INSTANCE?: CloudRepository(ctx)
        }
    }
    init {
        INSTANCE= CloudRepository(ctx)
    }

    fun getCloudDocument(key: String):DocumentReference?{
        var doc=firestoreInstance?.collection(BASE_COLLECTION)?.document(key)
        return doc
    }
    fun getMultiDocument(key: String):List<DocumentReference>?{
        firestoreInstance?.collection(BASE_COLLECTION)?.get()?.addOnCompleteListener {
            if(it.isSuccessful){
                /*retrive all document*/
                var documentlist=ArrayList<DocumentReference>()
                for (document in it.result!!){
                    documentlist.add(document.reference)
                }
                return documentlist
            }else{
                /*handle failure*/
            }
        }
        return null
    }
}