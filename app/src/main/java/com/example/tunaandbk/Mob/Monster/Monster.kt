package com.example.tunaandbk.Mob.Monster

import com.example.tunaandbk.Mob.Skill.*

abstract class Monster(val name:String, val hp:Int, val damage:Double)
{
    val skills:MutableList<Skill> = mutableListOf()
}