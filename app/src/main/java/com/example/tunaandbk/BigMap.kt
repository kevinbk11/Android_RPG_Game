package com.example.tunaandbk

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Bitmap.createBitmap
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.view.animation.ScaleAnimation
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.graphics.drawable.toBitmap
import com.example.tunaandbk.Mob.Skill.PlayerSkill.SwordAttack
import com.example.tunaandbk.System.*
import kotlinx.android.synthetic.main.activity_big_map.*

class BigMap : AppCompatActivity(), FileReadOrWrite,UIExtension {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_map)
        activityList.add(this)
        button3.setScaleAnimation()
        imageButton.setCheckColor()
        player!!.learnSkill(SwordAttack())
    }
    fun ccc(view:View)
    {
        Thread{
             Thread.sleep(20)
            Log.v("TEST","$r:$g:$b")
        }.start()
    }
}
