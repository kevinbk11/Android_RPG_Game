package com.example.tunaandbk.System

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.view.*
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.ImageButton
import android.widget.RelativeLayout
import androidx.core.graphics.drawable.toBitmap
import com.example.tunaandbk.MainActivity
import com.example.tunaandbk.R
import com.example.tunaandbk.ZoomInMap
import kotlinx.android.synthetic.main.activity_big_map.*

fun hideBar(window: Window)
{
    window.decorView.systemUiVisibility= View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
    window.decorView.setOnSystemUiVisibilityChangeListener {
            v->
        if(v and View.SYSTEM_UI_FLAG_FULLSCREEN==0)
        {
            window.decorView.systemUiVisibility=
                View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        }
    }
}
fun checkColor(imageButton:ImageButton,e: MotionEvent):Boolean
{
    val imgbmp = imageButton.drawable.toBitmap()
    val px=imgbmp.getPixel(e!!.x.toInt(),e.y.toInt())
    val r = Color.red(px)
    val g = Color.green(px)
    val b = Color.blue(px)
    if(r==g && g==b && r==0)return false
    return true
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

