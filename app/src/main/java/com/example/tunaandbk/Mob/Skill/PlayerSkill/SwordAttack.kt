package com.example.tunaandbk.Mob.Skill.PlayerSkill

import android.util.Log
import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.System.monsterDmgText
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlin.random.Random.Default.nextDouble

class SwordAttack: Skill() {
    override val name: String="重劍劈砍"
    override var dmgList = listOf((player.damage* nextDouble(1.2,1.5)).toInt())
    override fun use():List<Int> {
        dmgList=listOf((player.damage* nextDouble(1.2,1.5)).toInt(),(player.damage* nextDouble(1.2,1.5)).toInt())
        Log.v("?TEST","HI${dmgList}")
        player.mp-=10
        super.use()
        return dmgList
    }
}