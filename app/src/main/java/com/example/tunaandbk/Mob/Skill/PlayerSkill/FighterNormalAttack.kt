package com.example.tunaandbk.Mob.Skill.PlayerSkill

import android.util.Log
import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.System.fighting
import com.example.tunaandbk.System.monsterDmgText
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlin.random.Random

class FighterNormalAttack: Skill() {
    override fun use(dmgList:MutableList<Int>):List<Int> {
        for(i in 0..0)
        {
            dmgList+=((player.damage* Random.nextDouble(0.8,1.2)).toInt())
        }
        return dmgList
    }
}