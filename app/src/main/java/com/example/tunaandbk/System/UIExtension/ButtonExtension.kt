package com.example.tunaandbk.System.UIExtension

import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.Button
import android.widget.ImageButton
import androidx.core.graphics.drawable.toBitmap
import com.example.tunaandbk.System.GetResource
import com.example.tunaandbk.System.b
import com.example.tunaandbk.System.g
import com.example.tunaandbk.System.r

interface ButtonExtension:GetResource {

    fun ImageButton.checkColor(): Boolean {
        return !(r == g && g == b && r == 0)
    }

    fun ImageButton.setCheckColor() {
        val imgbmp = this.drawable.toBitmap()
        this.setOnTouchListener(object : View.OnTouchListener {
            @SuppressLint("ClickableViewAccessibility")
            override fun onTouch(view: View?, e: MotionEvent?): Boolean {
                if (e!!.action == MotionEvent.ACTION_DOWN) {
                    val dx = (view!!.width - imgbmp.width) / 2
                    val dy = (view.height - imgbmp.height) / 2
                    if ((e.x >= dx && e.y >= dy) && (e.x <= imgbmp.width + dx && e.y <= imgbmp.height + dy)) {
                        val px = imgbmp.getPixel(e!!.x.toInt() - dx, e.y.toInt() - dy)
                        r = Color.red(px)
                        g = Color.green(px)
                        b = Color.blue(px)
                    }

                }
                return false
            }
        })
    }
    fun Button.setScaleAnimation() {
        this.setOnTouchListener(object : View.OnTouchListener {
            @SuppressLint("ClickableViewAccessibility")
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                if (p1!!.action == MotionEvent.ACTION_DOWN) {
                    val am = ScaleAnimation(
                        1.0f, 0.9f, 1.0f, 0.9f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                    )
                    am!!.duration = 0
                    am.fillAfter = true
                    p0!!.startAnimation((am))
                } else if (p1!!.action == MotionEvent.ACTION_UP) {
                    val am = ScaleAnimation(
                        0.9f, 1.0f, 0.9f, 1.0f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                    )
                    am!!.duration = 0
                    am.fillAfter = true
                    p0!!.startAnimation((am))
                }
                return false
            }
        })

    }

    fun ImageButton.setScaleAnimation(r: Resources, p:String) {
        val btn = this
        this.setOnTouchListener(object : View.OnTouchListener {
            @SuppressLint("ClickableViewAccessibility")
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                if (p1!!.action == MotionEvent.ACTION_DOWN) {
                    btn.setBackgroundResource(getImageResources(r,"bt_login_2","mipmap",p))
                    val am = ScaleAnimation(
                        1.0f, 0.9f, 1.0f, 0.9f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                    )
                    am!!.duration = 0
                    am.fillAfter = true
                    btn.startAnimation(am)

                } else if (p1!!.action == MotionEvent.ACTION_UP) {
                    btn.setBackgroundResource(getImageResources(r,"bt_login_1","mipmap",p))
                    val am = ScaleAnimation(
                        0.9f, 1.0f, 0.9f, 1.0f,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f
                    )
                    am!!.duration = 0
                    am.fillAfter = true
                    btn!!.startAnimation(am)

                }
                return false
            }
        })
    }

}