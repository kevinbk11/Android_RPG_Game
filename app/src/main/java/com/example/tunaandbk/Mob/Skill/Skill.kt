package com.example.tunaandbk.Mob.Skill

import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.example.tunaandbk.System.*
import com.example.tunaandbk.System.textViewFun.TextViewExtension

abstract class Skill:TextViewExtension{
    override var alphaAnimationProcessing: Boolean=false
    open val dmgList:List<Int> = listOf()
    open val name = ""
    open fun use():List<Int>{
        if(fighting.turn==0)nowMonster.hp-=dmgList.sum()
        else player.hp-=dmgList.sum()
        return dmgList
    }

}