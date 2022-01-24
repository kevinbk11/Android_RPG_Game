package com.example.tunaandbk.System.UIExtension

import android.util.Log
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.ImageView
import kotlin.math.asin
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.tunaandbk.R
import com.example.tunaandbk.System.fighting
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player

interface TextViewExtension {
    fun startDmgTextViewAnimation(dmgTextViewList:List<TextView>, dmgList:List<Int>, now:Int=0, app:AppCompatActivity){
        if(now==dmgList.size)return
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
                    if(now+1==dmgList.size)
                    {
                        fighting.turn=(fighting.turn+1)%2
                        Log.v("test","${fighting.turn}")
                        if(fighting.turn==0)
                        {
                            fighting.roundProcessing=false
                            Log.v("test","?WHYWHY")
                        }
                        fighting.checkEnd()
                    }
                }

                override fun onAnimationRepeat(p0: Animation?) {

                }
            })
            app.runOnUiThread{
                dmgTextViewList[now].isVisible=true
            }
            Thread{
                dmgTextViewList[now].startAnimation(inAnim)
                Thread.sleep(600/dmgList.size.toLong())
                startDmgTextViewAnimation(dmgTextViewList, dmgList, now+1,app)
                var time:Long =100
                if(dmgList.size!=1)time = 100+(dmgList.size.toLong()-1)*250
                Thread.sleep(time)
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
        startDmgTextViewAnimation(dmgTextViewList,dmgList,0,app)
    }
}