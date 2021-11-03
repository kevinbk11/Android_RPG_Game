package com.example.tunaandbk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.tunaandbk.Mob.Skill.MonsterSkill.BirdAttack
import com.example.tunaandbk.Mob.Skill.MonsterSkill.StoneAttack
import com.example.tunaandbk.Mob.Skill.PlayerSkill.SwordAttack
import com.example.tunaandbk.RecyclerView.RecyclerViewPackage.skillRecyclerView
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlinx.android.synthetic.main.activity_fighting_page.*

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
        Log.v("fightInfo","player:${player!!.HP},${nowMonster.name}:${nowMonster.hp}")
    }
}