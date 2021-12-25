package com.example.tunaandbk.Mob.Skill.MonsterSkill

import android.util.Log
import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlin.random.Random

class StoneAttack: Skill() {
    override val name = "重石滾動"
    override fun use(dmgList:MutableList<Int>):List<Int> {
        dmgList+=((nowMonster.damage*1.5* Random.nextDouble(0.8, 1.0)).toInt())
        super.use(dmgList)
        return dmgList
    }
}