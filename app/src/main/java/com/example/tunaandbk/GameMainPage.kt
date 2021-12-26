package com.example.tunaandbk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import com.example.tunaandbk.Mob.Monster.Monster
import com.example.tunaandbk.System.*
import com.example.tunaandbk.System.UIExtension.WindowExtension
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_game_main_page.*

class GameMainPage : AppCompatActivity(),FileReadOrWrite,WindowExtension {
    val db = Firebase.firestore
    var now = ""
    var nextMapNumber = ""
    var monsterList = mutableListOf<Monster>()
    override fun onBackPressed() {
        for(a in activityList)a.finish()
        val db = Firebase.firestore
        db.collection("users").document(player.account).update("online",false)
        player.save()
        Thread.sleep(500)
        android.os.Process.killProcess(android.os.Process.myPid())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_main_page)
        activityList.add(this)
        window.hideBar()
        //contextMap.put(4,this)
        //player.put(WoodSword,1)
        val nowMapNumber=player.nowMapNumber

        db.collection("Maps").document(nowMapNumber).get().addOnSuccessListener {
            result->
            now=result.data!!["name"].toString()
            textView.text=now
            nextMapNumber=result.data!!["next"].toString()
            val monsterArrayList = result.data!!["monsterList"] as ArrayList<String>
            fightButton.isVisible = monsterArrayList.size != 0
            Thread.sleep(800)
        }
        player.save()
    }
    fun next(view: View)
    {
        db.collection("Maps").document(nextMapNumber).get().addOnSuccessListener {
                result->
            monsterList = mutableListOf<Monster>()
            now=result.data!!["name"].toString()
            textView.text=now
            player.nowMapNumber=nextMapNumber
            nextMapNumber=result.data!!["next"].toString()
            for(m in result.data!!["monsterList"] as List<String>)
            {
                monsterList.add(monsterMap[m]!!)
            }
            fightButton.isVisible = monsterList.size != 0
            Thread.sleep(400)
            player.save()
        }
    }
    fun goFight(view:View)
    {
        val intent = Intent(this@GameMainPage,ZoomInMap::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
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
    }
    fun big_map(view: View)
    {
        val intent = Intent(this@GameMainPage,BigMap::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
    }
}