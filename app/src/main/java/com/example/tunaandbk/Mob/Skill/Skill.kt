package com.example.tunaandbk.Mob.Skill

import com.example.tunaandbk.System.*
import com.example.tunaandbk.System.UIExtension.TextViewExtension

abstract class Skill: TextViewExtension {
    open val name = ""
    open fun use(dmgList:MutableList<Int> = mutableListOf()):List<Int>{
        /*if(fighting.turn==0)nowMonster.hp-=dmgList.sum()
        else player.hp-=dmgList.sum()*/
        return dmgList
    }

}