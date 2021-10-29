package com.example.tunaandbk

import android.content.Intent
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
import com.example.tunaandbk.Item.Equipment.Hand.Fighter.WoodSword
import com.example.tunaandbk.Mob.Monster.Monster
import com.example.tunaandbk.System.FileReadOrWrite
import com.example.tunaandbk.System.hideBar
import com.example.tunaandbk.System.monsterMap
import com.example.tunaandbk.System.player
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_game_main_page.*
import java.time.Instant
import kotlin.random.Random

class GameMainPage : AppCompatActivity(),FileReadOrWrite {
    val db = Firebase.firestore
    var now = ""
    var next = ""
    var monsterList = mutableListOf<Monster>()
    override fun onBackPressed() {
        this.finishAndRemoveTask()
    }
    override fun onDestroy() {
        super.onDestroy()
        val db = Firebase.firestore
        db.collection("users").document(player!!.account).update("online",false)
        player!!.save()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_main_page)
        hideBar(window)
        //player!!.put(WoodSword,1)
        db.collection("Maps").document("0001").get().addOnSuccessListener {
            result->
            now=result.data!!["name"].toString()
            textView.text=now
            next=result.data!!["next"].toString()
            Thread.sleep(800)
        }
    }
    fun next(view: View)
    {
        db.collection("Maps").document(next).get().addOnSuccessListener {
                result->
            monsterList = mutableListOf<Monster>()
            now=result.data!!["name"].toString()
            textView.text=now
            next=result.data!!["next"].toString()
            for(m in result.data!!["monsterList"] as List<String>)
            {
                monsterList.add(monsterMap[m]!!)
            }
            Thread.sleep(400)
        }
    }
    fun getMonster(view:View)
    {
        /*val btn1= Button(this)
        btn1.text="t"
        val btn2= Button(this)
        btn2.text="tt"
        btn1.layoutParams= FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,100 , Gravity.CLIP_HORIZONTAL)
        btn2.layoutParams= FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,100 , Gravity.CLIP_HORIZONTAL)
        test.addView(btn1)
        test.addView(btn2)*/
        for(m in monsterList)
        {
            Log.v("monster",m.name)
        }
    }
    fun big_map(view: View)
    {
        val intent = Intent(this@GameMainPage,BigMap::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
    }
}