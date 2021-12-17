package com.example.tunaandbk.System

import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.tunaandbk.System.UIExtension.TextViewExtension

class Fighting(val context: AppCompatActivity? = null): TextViewExtension {
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
        if(player.isDead()) { player.respawn() }
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
        if(nowMonster.isDead()) { fighting.endFighting() }
        else if(turn==1) { showDmg(playerDmgText,nowMonster.attack(),context!!) }
        if(player.isDead()) { fighting.endFighting() }
    }
    fun startThisRound()
    {
        this.changeFightingButtonClickable(false)
        Thread{
            this.waitAnimationEnd()
            this.changeFightingButtonClickable(true)
        }.start()
        if(skillPosition==-1)showDmg(monsterDmgText,player.normalAttack(),context!!)
        else showDmg(monsterDmgText,player.skillList[skillPosition].use(),context!!)
    }
    fun waitAnimationEnd()
    {
        this.roundProcessing=true
        while(this.roundProcessing){ Thread.sleep(100) }
    }
    fun changeFightingButtonClickable(state:Boolean)
    {
        for(button in fightingButtonList)
        {
            button.isClickable=state
        }
    }
}