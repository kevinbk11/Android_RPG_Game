package com.example.tunaandbk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.tunaandbk.RecyclerView.RecyclerViewPackage.skillRecyclerView
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlinx.android.synthetic.main.activity_fighting_page.*
import kotlin.random.Random.Default.nextDouble

class FightingPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fighting_page)
        val skillPanelLayout = skillRecyclerView(this,RV)
        skillPanelLayout.build(this)
        if(player!!.speed<= nowMonster.speed)
        {
            nowMonster.attack()
        }
        Log.v("fightInfo","player:${player!!.hp},${nowMonster.name}:${nowMonster.hp}")
    }

    fun normalAttack(view:View)
    {
        nowMonster.hp-=((player!!.damage)*nextDouble(0.8,1.2)).toInt()
        if(nowMonster.isDead())
        {
            onBackPressed()
            player!!.save()
        }
        nowMonster.attack()
        if(player!!.isDead())
        {
            onBackPressed()
            player!!.respawn()
            player!!.save()
        }
    }

}