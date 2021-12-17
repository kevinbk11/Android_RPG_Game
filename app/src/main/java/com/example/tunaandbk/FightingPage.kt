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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fighting_page)
        val skillPanelLayout = skillRecyclerView(this,RV)
        skillPanelLayout.build(this)
        fighting=Fighting(this)
        fighting.start()
        monsterDmgText=listOf(monsterDmg1,monsterDmg2,monsterDmg3,monsterDmg4,monsterDmg5,monsterDmg6)
        playerDmgText=listOf(playerDmgText1,playerDmgText2)
        fightingButtonList=(skillPanelLayout.RV.adapter as RecyclerViewAdapter).skillButtonList
        fightingButtonList.add(attackButton)
        fightingButtonList.add(itemButton)
        fightingButtonList.add(runButton)
        Log.v("fightInfo","player:${player.hp},${nowMonster.name}:${nowMonster.hp}")
    }

    fun normalAttack(view:View)
    {
        skillPosition=-1
        fighting.startThisRound()
    }
}