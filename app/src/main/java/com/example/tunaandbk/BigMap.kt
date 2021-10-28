package com.example.tunaandbk

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import com.example.tunaandbk.System.FileReadOrWrite

class BigMap : AppCompatActivity(), FileReadOrWrite {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_map)
    }
    fun t(view: View,e:MotionEvent)
    {
        Log.v("testtest","test")
    }
}
