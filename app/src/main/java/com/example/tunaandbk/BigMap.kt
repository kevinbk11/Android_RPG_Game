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
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.graphics.drawable.toBitmap
import com.example.tunaandbk.System.FileReadOrWrite
import com.example.tunaandbk.System.activityList
import com.example.tunaandbk.System.checkColor
import kotlinx.android.synthetic.main.activity_big_map.*

class BigMap : AppCompatActivity(), FileReadOrWrite {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_map)
        activityList.add(this)
        /*imageButton.setOnTouchListener(object: View.OnTouchListener{
            override fun onTouch(view: View?, e: MotionEvent?): Boolean {
                if(checkColor(imageButton,e!!))
                {
                    //TODO
                    return true
                }
                else return false
            }
        })*/
    }
}
