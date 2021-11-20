package com.example.tunaandbk.Mob.Skill

import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.example.tunaandbk.System.UIExtension
import com.example.tunaandbk.System.monsterDmgText
import com.example.tunaandbk.System.textViewFun.TextViewExtension

abstract class Skill:TextViewExtension{
    override var alphaAnimationProcessing: Boolean=false
    open val name = ""
    open fun use(){}

}