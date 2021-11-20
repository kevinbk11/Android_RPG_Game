package com.example.tunaandbk.System.textViewFun

import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Button
import android.widget.TextView
import com.example.tunaandbk.System.fighting
import com.example.tunaandbk.System.monsterDmgText
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player

interface TextViewExtension {
    var alphaAnimationProcessing:Boolean
    fun startAlphaAnimation(dmgTextList:List<TextView>,now:Int=0,max:Int){
        if(now==max)return
        else
        {
            val outAnim = AlphaAnimation(1.0f,0.0f)
            outAnim.duration=500
            outAnim.setAnimationListener(object: Animation.AnimationListener{
                override fun onAnimationStart(p0: Animation?) {
                    Thread{
                        Thread.sleep(300)
                        startAlphaAnimation(dmgTextList,now+1,max)
                    }.start()
                }

                override fun onAnimationEnd(p0: Animation?) {
                    dmgTextList[now].text=""
                    if(now+1==max)
                    {
                        alphaAnimationProcessing=false
                        fighting.turn=(fighting.turn+1)%2
                        if(fighting.turn==0)fighting.roundProcessing=false
                        fighting.checkEnd()
                    }
                }

                override fun onAnimationRepeat(p0: Animation?) {

                }
            })
            dmgTextList[now].startAnimation(outAnim)
        }
    }
    fun showDmg(dmgTextList:List<TextView>, dmgList:List<Int>)
    {
        alphaAnimationProcessing=true
        for(i in dmgList.indices)
        {
            dmgTextList[i].text=dmgList[i].toString()
        }
        Thread{
            Thread.sleep(1000)
            startAlphaAnimation(dmgTextList,0,dmgList.size)
        }.start()
    }
}