package com.example.tunaandbk.System

import android.util.Log
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.tunaandbk.R
import com.example.tunaandbk.System.UIExtension.ImageViewExtension
import com.example.tunaandbk.System.UIExtension.TextViewExtension

class Fighting(val context: AppCompatActivity? = null): TextViewExtension,ImageViewExtension {
    var turn = 0
    var roundProcessing = false
    fun start()
    {
        Log.v("testI",(player.HP.toFloat()/player.fullHP).toString())
        val animation = ScaleAnimation(
            1.0f,// x起始縮放比例
            player.HP.toFloat()/player.fullHP, // x結束縮放比例
            1.0f,// x起始縮放比例
            1.0f, // y結束縮放比例
            Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, 1f)
        animation.duration=0
        animation.fillAfter=true
        val hpBar = context!!.findViewById<ImageView>(R.id.playerHpBar)
        hpBar.startAnimation(animation)
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
        else if(turn==1)
        {
            val dmgList = nowMonster.attack()
            showDmg(playerDmgText,dmgList,context!!)
            val hpBar: ImageView = context.findViewById(R.id.playerHpBar)
            hpBar.startGetDamageAnimation(dmgList,app=context)
        }
        if(player.isDead()) { fighting.endFighting() }
    }
    fun startThisRound()
    {
        this.changeFightingButtonClickable(false)
        Thread{
            this.waitAnimationEnd()
            this.changeFightingButtonClickable(true)
        }.start()
        val dmgList:List<Int> = if(skillPosition==-1)player.normalAttack() else player.skillList[skillPosition].use()
        showDmg(monsterDmgText,dmgList,context!!)
        val hpBar: ImageView = context.findViewById(R.id.monsterHpBar)
        hpBar.startGetDamageAnimation(dmgList,app=context)

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