package com.example.tunaandbk.Mob.Monster

import com.example.tunaandbk.Item.Item
import com.example.tunaandbk.Mob.Skill.*
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlin.random.Random.Default.nextDouble

abstract class Monster(val name:String, private var FullHP:Int, val damage:Double,val speed:Double,val money:Int,val item:List<Item>)
{
    var hp = FullHP
    val skills:MutableList<Skill> = mutableListOf()
    open fun attack(){}
    fun isDead():Boolean{return hp<=0}
    fun dropMoney(){player!!.money += (money*nextDouble(0.8,1.2)).toInt()}
    fun dropItem(){}
}