package com.example.tunaandbk.Mob.Monster

import com.example.tunaandbk.Mob.Skill.*
import com.example.tunaandbk.System.player
import kotlin.random.Random.Default.nextDouble

abstract class Monster(val name:String, private var FullHP:Int, val damage:Double,val speed:Double)
{
    var hp = FullHP
    val skills:MutableList<Skill> = mutableListOf()
    open fun attack(){}
}