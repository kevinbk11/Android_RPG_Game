package com.example.tunaandbk.Mob.Monster

import com.example.tunaandbk.Item.Item
import com.example.tunaandbk.Mob.Skill.*
import kotlin.random.Random.Default.nextDouble

abstract class Monster(val name:String, var fullHP:Int, val damage:Double, val speed:Double, val money:Int, val exp:Int, val item:List<Item>)
{
    var hp = fullHP
    val skills:MutableList<Skill> = mutableListOf()
    open fun attack():List<Int>{return listOf()}
    fun isDead():Boolean{return hp<=0}
    fun dropMoney():Int{return (money*nextDouble(0.8,1.2)).toInt()}
    //fun dropItem(){}
}