package com.example.tunaandbk.System.UIExtension

import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.tunaandbk.System.fighting

interface TextViewExtension {
    fun startAlphaAnimation(dmgTextViewList:List<TextView>,dmgList:List<Int>, now:Int=0, max:Int,app:AppCompatActivity){
        if(now==max)return
        else
        {
            val inAnim = AlphaAnimation(0.0f,1.0f)
            inAnim.duration=500
            val outAnim = AlphaAnimation(1.0f,0.0f)
            outAnim.duration=500
            outAnim.setAnimationListener(object: Animation.AnimationListener{
                override fun onAnimationStart(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    dmgTextViewList[now].text=""
                    if(now+1==max)
                    {
                        fighting.turn=(fighting.turn+1)%2
                        if(fighting.turn==0)fighting.roundProcessing=false
                        fighting.checkEnd()
                    }
                }

                override fun onAnimationRepeat(p0: Animation?) {

                }
            })
            inAnim.setAnimationListener(object: Animation.AnimationListener{
                override fun onAnimationStart(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {

                }

                override fun onAnimationRepeat(p0: Animation?) {

                }
            })
            app.runOnUiThread{
                dmgTextViewList[now].isVisible=true
            }
            Thread{
                dmgTextViewList[now].startAnimation(inAnim)
                Thread.sleep(300)
                startAlphaAnimation(dmgTextViewList, dmgList, now+1, max,app)
                Thread.sleep(1000)
                dmgTextViewList[now].startAnimation(outAnim)
            }.start()
        }
    }
    fun showDmg(dmgTextViewList:List<TextView>, dmgList:List<Int>,app:AppCompatActivity)
    {
        for(now in dmgList.indices)
        {
            dmgTextViewList[now].text=dmgList[now].toString()
            dmgTextViewList[now].isVisible=false
        }
        startAlphaAnimation(dmgTextViewList,dmgList,0,dmgList.size,app)
    }
}