package com.example.tunaandbk.Player

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

abstract class Player(name:String) {
    open var id:String=""
    open var name:String=name
    open var job:String=""
    open var HP:Int=0
    open var MP:Int=0
    open var FullHP:Int=0
    open var FullMP:Int=0
    open var Damage = 0.0

    open var LV:Int=0
    open var FullEXP:Double=0.0
    open var EXP:Double=0.0

    open var Money:Int=0
    open fun levelup(){}
    fun getId()
    {
        val db= Firebase.firestore
        db.collection("users").get().addOnSuccessListener {
            result->
            for(user in result)
            {
                if(user["name"]==name)id=user.id
            }
        }
    }
    fun save()
    {
        val db = Firebase.firestore
        db.collection("users").document(id).update("playerData",this)
    }


}