package com.example.tunaandbk.System

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.tunaandbk.MainActivity
import com.example.tunaandbk.Mob.Monster.Monster
import com.example.tunaandbk.Mob.Player.Player
import com.example.tunaandbk.System.textViewFun.TextViewExtension

class Fighting(val context: AppCompatActivity? = null):TextViewExtension {
    override var alphaAnimationProcessing: Boolean=false
    var turn = 0
    var roundProcessing = false
    fun start()
    {
        if(player.speed<nowMonster.speed)
        {
            Log.v("?TEST", "${player.speed},${nowMonster.speed}")
            turn = 1
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
        else if(turn==1)
        {
            showDmg(playerDmgText,nowMonster.attack())
        }
        if(player.isDead())
        {
            fighting.endFighting()
        }
    }
    fun startThisRound()
    {
        if(skillPosition==-1)showDmg(monsterDmgText,player.normalAttack())
        else showDmg(monsterDmgText,player.skillList[skillPosition].use())
        Thread{
            while(alphaAnimationProcessing)
            {
                Thread.sleep(100)
            }
        }.start()
    }
}