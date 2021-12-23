package com.example.tunaandbk.Mob.Player

import com.example.tunaandbk.Item.EmptyItem
import com.example.tunaandbk.Item.Equipment.Equipment
import com.example.tunaandbk.Item.Item
import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.System.player
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.math.pow

abstract class Player(name:String,acc:String){
    open var account:String=acc
    open var name:String=name
    open var job:String=""
    open var HP:Int=0
    open var mp:Int=0
    open var fullHP:Int=0
    open var fullMP:Int=0
    open var damage = 0.0
    open var skillList= mutableListOf<Skill>()
    open var lv:Int=0
    open var fullEXP:Double=0.0
    open var exp:Double=0.0
    open var speed=0.0
    open var money:Int=0

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
        lv+=1
        exp-=fullEXP
        fullEXP=150+(1.8).pow(lv*0.35)
    }
    fun save()
    {
        val db = Firebase.firestore
        db.collection("users").document(account).update("playerData",this)
    }
    private fun p(item:Item,value:Int)
    {
        var find = false
        val matchedItem=bag[item.type]!!.filter{it.name==item.name}
        if(matchedItem.isNotEmpty())
        {
            matchedItem[0]+=value
        }
        else
        {
            val emptyItem=bag[item.type]!!.filter{it.name=="none"}
            with(bag[item.type]!!)
            {
                val emptyPlace=this.indexOf(emptyItem[0])
                this[emptyPlace]=item
                this[emptyPlace]+=value
            }
        }
    }
    fun getMoney(money:Int)
    {
        player.money+=money
    }
    fun getExp(exp:Int)
    {
        player.exp+=exp
        if(player.exp>=player.fullEXP)
        {
            player.levelup()
        }
    }
    fun getItem(item: Item?, value:Int)
    {
        when(item)
        {
            is Equipment ->
            {
                p(item,value)
            }
        }
    }
    fun learnSkill(skill: Skill)
    {
        skillList.add(skill)
    }
    fun respawn()
    {
        HP=(fullHP*0.1).toInt()
        mp=(fullMP*0.1).toInt()
    }
    fun isDead():Boolean{return HP<=0}
    open fun normalAttack():List<Int>{
        return listOf()
    }

}