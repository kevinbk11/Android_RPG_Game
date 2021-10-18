package com.example.tunaandbk

import android.content.res.Resources
import android.util.Log
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

interface FileReadOrWrite {
    fun getImageResources(r: Resources, name:String, type:String, p:String?):Int
    {
        return r.getIdentifier(name,type,p)
    }
    fun addUserToFirebase(user:HashMap<String,String>)
    {
        val db = Firebase.firestore
        db.collection("users").add(user)
    }

}