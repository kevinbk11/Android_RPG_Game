package com.example.tunaandbk.Mob.Skill.PlayerSkill

import android.util.Log
import com.example.tunaandbk.Mob.Player.Job.Fighter
import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.System.monsterDmgText
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlin.random.Random

class FighterNormalAttack: Skill() {
    override fun use()
    {
        val a = listOf(((player.damage)* Random.nextDouble(0.8, 1.2)).toInt())
        nowMonster.hp-=a[0]
        monsterDmgText[0].text=a[0].toString()
        showDmg(a)
    }
}