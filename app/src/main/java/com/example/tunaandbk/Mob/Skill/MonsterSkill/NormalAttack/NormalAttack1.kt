package com.example.tunaandbk.Mob.Skill.MonsterSkill.NormalAttack

import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlin.random.Random
import kotlin.random.Random.Default.nextDouble

class NormalAttack1: Skill() {
    override val name = "普通攻擊"
    override fun use(dmgList:MutableList<Int>):List<Int> {
        dmgList+=((nowMonster.damage*nextDouble(0.8, 1.2)).toInt())
        super.use(dmgList)
        return dmgList
    }
}