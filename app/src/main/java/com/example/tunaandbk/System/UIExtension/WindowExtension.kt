package com.example.tunaandbk.System.UIExtension

import android.app.AlertDialog
import android.view.View
import android.view.Window
import com.example.tunaandbk.R

interface WindowExtension {
    fun Window.hideBar() {
        this.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        this.decorView.setOnSystemUiVisibilityChangeListener { v ->
            if (v and View.SYSTEM_UI_FLAG_FULLSCREEN == 0) {
                this.decorView.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            }
        }
    }


    fun AlertDialog.showCheckFight() {
        this.show()
        this.window!!.setBackgroundDrawableResource(android.R.color.transparent)
        this.window!!.setContentView(R.layout.fight_recheck)
    }

}