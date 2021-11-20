package com.example.tunaandbk.System

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import com.example.tunaandbk.MainActivity
import com.example.tunaandbk.Mob.Monster.Monster
import com.example.tunaandbk.Mob.Player.Player
import com.example.tunaandbk.System.textViewFun.TextViewExtension

class Fighting(val context: AppCompatActivity? = null):TextViewExtension {
    override var alphaAnimationProcessing: Boolean=false
    var roundProcessing = false
    fun start()
    {
        if(player.speed<nowMonster.speed)
        {
            nowMonster.attack()
        }
    }
    fun endFighting()
    {
        if(player.isDead())
        {
            player.respawn()
        }
        else
        {
            player.getMoney(nowMonster.dropMoney())
            player.getExp(nowMonster.exp)
        }
        context!!.onBackPressed()
        player.save()
    }
    fun checkEnd()
    {
        if(nowMonster.isDead())
        {
            fighting.endFighting()
        }
        else
        {
            nowMonster.attack()
        }
        if(player.isDead())
        {
            fighting.endFighting()
        }
    }
    fun startThisRound()
    {
        if(skillPosition==-1)player.normalAttack()
        else player.skillList[skillPosition].use()
        while(alphaAnimationProcessing)
        {
            Thread{
                Thread.sleep(100)
            }.start()
        }
        roundProcessing=false
    }
}