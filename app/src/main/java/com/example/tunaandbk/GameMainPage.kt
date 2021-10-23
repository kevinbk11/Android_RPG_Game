package com.example.tunaandbk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.example.tunaandbk.System.FileReadOrWrite
import com.example.tunaandbk.System.player
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_game_main_page.*
import java.time.Instant

class GameMainPage : AppCompatActivity(),FileReadOrWrite {
    val db = Firebase.firestore
    var now = ""
    var next = ""
    override fun onBackPressed() {
    }

    /*override fun onStart() {
        super.onStart()
        player!!.online=true
        player!!.save()
    }*/

    override fun onStop() {
        super.onStop()
        val db = Firebase.firestore
        db.collection("users").document(player!!.account).update("online",false)
        player!!.save()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_main_page)
        db.collection("Maps").document("0001").get().addOnSuccessListener {
            result->
            now=result.data!!["name"].toString()
            textView.text=now
            next=result.data!!["next"].toString()
            Thread.sleep(400)
        }
    }
    fun next(view: View)
    {
        db.collection("Maps").document(next).get().addOnSuccessListener {
                result->
            now=result.data!!["name"].toString()
            textView.text=now
            next=result.data!!["next"].toString()
            Thread.sleep(400)
        }
    }
    fun getMonster(view:View)
    {
        val btn1= Button(this)
        btn1.text="t"
        val btn2= Button(this)
        btn2.text="tt"
        btn1.layoutParams= FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,100 , Gravity.CLIP_HORIZONTAL)
        btn2.layoutParams= FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,100 , Gravity.CLIP_HORIZONTAL)
        test.addView(btn1)
        test.addView(btn2)
    }
}