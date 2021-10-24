package com.example.tunaandbk.Mob.Player

import com.example.tunaandbk.Item.EmptyItem
import com.example.tunaandbk.Item.Item
import com.example.tunaandbk.Item.Weapon
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

abstract class Player(name:String,acc:String) {
    open var account:String=acc

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

    open var bag:MutableMap<String,MutableList<Item>> = mutableMapOf(
        "equipment" to mutableListOf(),
        "consume" to mutableListOf(),
        "another" to mutableListOf()
    )
    init{
        for(i in 0..19)
        {
            bag["equipment"]!!.add(EmptyItem())
            bag["consume"]!!.add(EmptyItem())
            bag["another"]!!.add(EmptyItem())
        }
    }
    open fun levelup(){}
    fun save()
    {
        val db = Firebase.firestore
        db.collection("users").document(account).update("playerData",this)
    }
    private fun p(item:Item,value:Int,type:String)
    {
        var find = false
        for(i in bag[type]!!)
        {
            if(i.name==item.name)
            {
                find = true
                i.count+=value
                break
            }
        }
        if(!find)
        {
            for(i in bag[type]!!)
            {
                if(i.name=="none")
                {
                    val place = bag[type]!!.indexOf(i)
                    bag[type]!![place]=item
                    bag[type]!![place].count=value
                    break
                }
            }
        }
    }
    fun put(item: Item?, value:Int)
    {
        when(item)
        {
            is Weapon ->
            {
                p(item,value,"equipment")
            }
        }
    }
}