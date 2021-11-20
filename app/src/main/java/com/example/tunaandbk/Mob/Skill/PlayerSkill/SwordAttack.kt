package com.example.tunaandbk.Mob.Skill.PlayerSkill

import android.util.Log
import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlin.random.Random.Default.nextDouble
import kotlin.random.Random.Default.nextInt

class SwordAttack: Skill() {
    override val name: String="重劍劈砍"
    override fun use()
    {
        nowMonster.hp-=(player!!.Damage* nextDouble(1.2,1.5)).toInt()
        player!!.MP-=10
    }
}