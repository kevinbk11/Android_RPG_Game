package com.example.tunaandbk.System

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.util.Log
import android.view.*
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
import com.example.tunaandbk.R

interface UIExtension
{
    fun Window.hideBar()
    {
        this.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        this.decorView.setOnSystemUiVisibilityChangeListener {
                v->
            if(v and View.SYSTEM_UI_FLAG_FULLSCREEN==0)
            {
                this.decorView.systemUiVisibility=
                    View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            }
        }
    }
    fun ImageButton.checkColor():Boolean{
        return !(r==g&&g==b&&r==0)
    }
    fun ImageButton.setCheckColor()
    {
        val imgbmp = this.drawable.toBitmap()
        this.setOnTouchListener(object: View.OnTouchListener{
            @SuppressLint("ClickableViewAccessibility")
            override fun onTouch(view: View?, e: MotionEvent?): Boolean {
                if(e!!.action==MotionEvent.ACTION_DOWN)
                {
                    val dx = (view!!.width-imgbmp.width)/2
                    val dy = (view.height-imgbmp.height)/2
                    if((e.x>=dx &&e.y>=dy) && (e.x<=imgbmp.width+dx && e.y<=imgbmp.height+dy))
                    {
                        val px=imgbmp.getPixel(e!!.x.toInt()-dx,e.y.toInt()-dy)
                        r = Color.red(px)
                        g = Color.green(px)
                        b = Color.blue(px)
                    }

                }
                return false
            }
        })
    }
    fun AlertDialog.showCheckFight()
    {
        this.show()
        this.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        this.window!!.setContentView(R.layout.fight_recheck)
    }
    fun Button.setScaleAnimation()
    {
        this.setOnTouchListener(object:View.OnTouchListener{
            @SuppressLint("ClickableViewAccessibility")
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                if (p1!!.action == MotionEvent.ACTION_DOWN) {
                    val am = ScaleAnimation(1.0f, 0.9f, 1.0f,0.9f,
                        Animation.RELATIVE_TO_SELF,0.5f,
                        Animation.RELATIVE_TO_SELF,0.5f)
                    am!!.duration=100
                    am.fillAfter=true
                    p0!!.startAnimation((am))
                }
                else if(p1!!.action==MotionEvent.ACTION_UP)
                {
                    val am = ScaleAnimation(0.9f, 1.0f, 0.9f,1.0f,
                        Animation.RELATIVE_TO_SELF,0.5f,
                        Animation.RELATIVE_TO_SELF,0.5f)
                    am!!.duration=100
                    am.fillAfter=true
                    p0!!.startAnimation((am))
                }

                return false
            }
        })

    }
}
