package com.example.tunaandbk.Mob.Player

import android.util.Log
import com.example.tunaandbk.Item.EmptyItem
import com.example.tunaandbk.Item.Equipment.Equipment
import com.example.tunaandbk.Item.Item
import com.example.tunaandbk.Mob.Player.Job.Fighter
import com.example.tunaandbk.Mob.Skill.PlayerSkill.FighterNormalAttack
import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.System.monsterDmgText
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import com.example.tunaandbk.System.textViewFun.TextViewExtension
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlin.math.pow
import kotlin.random.Random.Default.nextDouble

abstract class Player(name:String,acc:String){
    open var account:String=acc

    open var name:String=name
    open var job:String=""
    open var hp:Int=0
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
    private fun p(item:Item,value:Int,type:String)
    {
        var find = false
        val matchedItem=bag[type]!!.filter{it.name==item.name}
        if(matchedItem.isNotEmpty())
        {
            matchedItem[0].count+=value
        }
        else
        {
            val emptyItem=bag[type]!!.filter{it.name=="none"}
            with(bag[type]!!)
            {
                val emptyPlace=this.indexOf(emptyItem[0])
                this[emptyPlace]=item
                this[emptyPlace].count+=value
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
                p(item,value,"equipment")
            }
        }
    }
    fun learnSkill(skill: Skill)
    {
        skillList.add(skill)
    }
    fun respawn()
    {
        hp=(fullHP*0.1).toInt()
        mp=(fullMP*0.1).toInt()
    }
    fun isDead():Boolean{return hp<=0}
    open fun normalAttack():List<Int>{
        return listOf()
    }

}