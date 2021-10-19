package com.example.tunaandbk.Player

import com.example.tunaandbk.Item.Item
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

    open var bag:MutableList<Item> = mutableListOf()
    open fun levelup(){}
    fun save()
    {
        val db = Firebase.firestore
        db.collection("users").document(id).update("playerData",this)
    }
    fun put(item: Item?, value:Int)
    {
        var find=false
        var Value=value
        for(x in this.bag)
        {
            if(x!!.name==item!!.name)
            {
                x.count+=Value
                find=true
                break
            }
        }
        if(find==false)
        {

        }
    }



}