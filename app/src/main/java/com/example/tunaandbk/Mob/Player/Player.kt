package com.example.tunaandbk.Mob.Player

import android.util.Log
import com.example.tunaandbk.Item.EmptyItem
import com.example.tunaandbk.Item.Equipment.Equipment
import com.example.tunaandbk.Item.Item
import com.example.tunaandbk.Item.Equipment.Hand.Weapon
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.math.pow

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
    open fun levelup()
    {
        LV+=1
        FullEXP=150+(1.8).pow(LV*0.35)
        EXP-=FullEXP
    }
    fun save()
    {
        val db = Firebase.firestore
        db.collection("users").document(account).update("playerData",this)
    }
    private fun p(item:Item,value:Int,type:String)
    {
        var find = false
        val matchedItem=bag[type]!!.filter{it.name==item.name}
        if(matchedItem.isNotEmpty())
        {
            Log.v("test","notEmpty")
            matchedItem[0].count+=value
        }
        else
        {
            Log.v("test","Empty")
            val emptyItem=bag[type]!!.filter{it.name=="none"}
            with(bag[type]!!)
            {
                val emptyPlace=this.indexOf(emptyItem[0])
                this[emptyPlace]=item
                Log.v("???TEST",this[emptyPlace].count.toString())
                this[emptyPlace].count+=value
            }
        }
        /*for(i in bag[type]!!)
        {
            if(i.name==item.name)
            {
                find = true

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
        }*/
    }
    fun put(item: Item?, value:Int)
    {
        when(item)
        {
            is Equipment ->
            {
                p(item,value,"equipment")
            }
        }
    }
}