package com.example.tunaandbk.System

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.view.*
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

fun getImageResources(r: Resources, name: String, type: String, p: String?): Int {
    return r.getIdentifier(name, type, p)
}

fun getXml(key:String):Int?
{
    val mapXml=mapOf(
        "伊納修" to R.layout.initial_city,
        "布德草原" to R.layout.bird_grassland
    )
    return mapXml[key]
}
fun showCheckFight(dialog:AlertDialog,WindowManager:WindowManager)
{
    dialog.show()
    val window = dialog.window
    dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)
    dialog!!.window!!.setContentView(R.layout.fight_recheck)
    val rl = window!!.findViewById(R.id.RL) as RelativeLayout
    val display = WindowManager.defaultDisplay
}