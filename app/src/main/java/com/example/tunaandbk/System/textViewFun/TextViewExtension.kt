package com.example.tunaandbk.System.textViewFun

import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.example.tunaandbk.System.fighting
import com.example.tunaandbk.System.monsterDmgText
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player

interface TextViewExtension {
    var alphaAnimationProcessing:Boolean
    fun startAlphaAnimation(now:Int=0,max:Int){
        if(now==max)return
        else
        {
            val outAnim = AlphaAnimation(1.0f,0.0f)
            outAnim.duration=500
            outAnim.setAnimationListener(object: Animation.AnimationListener{
                override fun onAnimationStart(p0: Animation?) {
                    Thread{
                        Thread.sleep(300)
                        startAlphaAnimation(now+1,max)
                    }.start()
                }

                override fun onAnimationEnd(p0: Animation?) {
                    monsterDmgText[now].text=""
                    if(now+1==max)
                    {
                        alphaAnimationProcessing=false
                        fighting.roundProcessing=false
                        fighting.checkEnd()
                    }
                }

                override fun onAnimationRepeat(p0: Animation?) {

                }
            })
            monsterDmgText[now].startAnimation(outAnim)
        }

    }
    fun showDmg(dmgList:List<Int>)
    {
        alphaAnimationProcessing=true
        for(i in dmgList.indices)
        {
            monsterDmgText[i].text=dmgList[i].toString()
        }
        Thread{
            Thread.sleep(1000)
            startAlphaAnimation(0,dmgList.size)
        }.start()

    }
}