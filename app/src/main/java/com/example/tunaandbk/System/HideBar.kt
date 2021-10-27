package com.example.tunaandbk.System

import android.view.View
import android.view.Window

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