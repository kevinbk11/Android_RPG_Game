package com.example.tunaandbk.System

import android.app.AlertDialog
import android.graphics.Color
import android.view.*
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.ImageButton
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
    fun ImageButton.setCheckColor()
    {
        val btn = this
        val imgbmp = this.drawable.toBitmap()
        this.setOnTouchListener(object: View.OnTouchListener{
            override fun onTouch(view: View?, e: MotionEvent?): Boolean {
                val px=imgbmp.getPixel(e!!.x.toInt(),e.y.toInt())
                btn.r = Color.red(px)
                btn.g = Color.green(px)
                btn.b = Color.blue(px)
                return true
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
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                var am:Animation? = null
                if (p1!!.action == MotionEvent.ACTION_DOWN) {
                    am = ScaleAnimation(1.0f, 0.9f, 1.0f,0.9f,
                        Animation.RELATIVE_TO_SELF,0.5f,
                        Animation.RELATIVE_TO_SELF,0.5f)
                }
                if(p1!!.action==MotionEvent.ACTION_UP)
                {
                    am = ScaleAnimation(0.9f, 1.0f, 0.9f,1.0f,
                        Animation.RELATIVE_TO_SELF,0.5f,
                        Animation.RELATIVE_TO_SELF,0.5f)

                }
                am!!.duration=100
                am.fillAfter=true
                p0!!.startAnimation((am))
                return true
            }
        })
    }
}
