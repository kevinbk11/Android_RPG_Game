package com.example.tunaandbk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.example.tunaandbk.RecyclerView.Adapter.RecyclerViewAdapter
import com.example.tunaandbk.RecyclerView.RecyclerViewPackage.skillRecyclerView
import com.example.tunaandbk.System.*
import kotlinx.android.synthetic.main.activity_fighting_page.*

class FightingPage : AppCompatActivity() {
    var skillButtonList:MutableList<Button> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fighting_page)
        val skillPanelLayout = skillRecyclerView(this,RV)
        skillPanelLayout.build(this)
        fighting=Fighting(this)
        fighting.start()
        monsterDmgText=listOf(monsterDmg1,monsterDmg2)
        skillButtonList=(skillPanelLayout.RV.adapter as RecyclerViewAdapter).skillButtonList
        skillButtonList.add(attackButton)
        Log.v("fightInfo","player:${player.hp},${nowMonster.name}:${nowMonster.hp}")
    }

    fun normalAttack(view:View)
    {
        skillPosition=-1
        fighting.startThisRound()
        for(button in skillButtonList)
        {
            button.isClickable=false
        }
        fighting.roundProcessing=true
        Thread{
            while(fighting.roundProcessing)
            {
                Thread.sleep(100)
            }
            for(button in skillButtonList)
            {
                button.isClickable=true
            }
        }.start()
    }
}