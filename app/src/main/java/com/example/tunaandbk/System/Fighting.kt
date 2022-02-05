package com.example.tunaandbk.System

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import android.widget.TextView
import com.example.tunaandbk.FightEndPage
import com.example.tunaandbk.FightingPage
import com.example.tunaandbk.R
import com.example.tunaandbk.System.UIExtension.ImageViewExtension
import com.example.tunaandbk.System.UIExtension.TextViewExtension

class Fighting(val context: FightingPage? =null): TextViewExtension,ImageViewExtension {
    var turn = 0
    var roundProcessing = false
    fun getBarAnimation(v1:Float,v2:Float):ScaleAnimation
    {
        val animation = ScaleAnimation(
            1.0f,// x起始縮放比例
            v1/v2, // x結束縮放比例
            1.0f,// x起始縮放比例
            1.0f, // y結束縮放比例
            Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, 1f)
        animation.duration=0
        animation.fillAfter=true
        return animation
    }
    fun start()
    {
        val playerHpTextView=context!!.findViewById<TextView>(R.id.player_hptext)
        playerHpTextView.text= "${player.HP}/${player.fullHP}"
        val monsterHpTextView=context!!.findViewById<TextView>(R.id.monster_hptext)
        monsterHpTextView.text="${nowMonster.hp}/${nowMonster.fullHP}"
        val playerMpTextView=context!!.findViewById<TextView>(R.id.player_mptext)
        playerMpTextView.text="${player.MP}/${player.fullMP}"
        Log.v("testI",(player.HP.toFloat()/player.fullHP).toString())

        val hpBar = context!!.findViewById<ImageView>(R.id.playerHpBar)
        val mpBar = context.findViewById<ImageView>(R.id.playerMpBar)
        hpBar.startAnimation(getBarAnimation(player.HP.toFloat(),player.fullHP.toFloat()))
        mpBar.startAnimation(getBarAnimation(player.MP.toFloat(), player.fullMP.toFloat()))
        Log.v("?TEST", "${player.MP},${player.fullMP}")
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
            val intent = Intent(context, FightEndPage::class.java)
            context!!.startActivity(intent)

        }
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
            val hpTextView=context.findViewById<TextView>(R.id.player_hptext)
            textViewValueDecrease(hpTextView,dmgList)
            hpBar.changeHPLengthAnimation(dmgList,app=context)
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
        val mpBar = context.findViewById<ImageView>(R.id.playerMpBar)
        val hpTextView=context.findViewById<TextView>(R.id.monster_hptext)
        val mpTextView=context.findViewById<TextView>(R.id.player_mptext)
        mpBar.changeMpLengthAnimation(if(skillPosition==-1) 0 else player.skillList[skillPosition].needMp)
        textViewValueDecrease(hpTextView,dmgList)
        textViewValueDecrease(mpTextView,listOf(player.skillList[skillPosition].needMp))
        hpBar.changeHPLengthAnimation(dmgList,app=context)

    }
    fun waitAnimationEnd()
    {
        this.roundProcessing=true
        while(this.roundProcessing)
        {
            Thread.sleep(100)
            Log.v("test","?why")
        }
    }
    fun changeFightingButtonClickable(state:Boolean)
    {
        for(button in fightingButtonList)
        {
            button.isClickable=state
        }
    }
    @SuppressLint("SetTextI18n")
    fun textViewValueDecrease(textView: TextView, dmgList:List<Int>)
    {
        val total = dmgList.sum()
        Log.v("test??",textView.text.toString())
        var now=textView.text.toString().split("/")[0].toInt()
        val full=textView.text.toString().split("/")[1].toInt()
        Log.v("test","tvvd")
            Thread{
                for(i in total downTo 1 )
                {
                    context!!.runOnUiThread{
                        if(now<=0)return@runOnUiThread
                        now--
                        textView.text="${now}/$full"
                    }
                    Thread.sleep(1000/total.toLong())
                    if(now<=0)break
                }
            }.start()

    }
}