package com.example.tunaandbk.Mob.Skill.MonsterSkill

import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlin.random.Random

class BirdAttack: Skill() {
    override val name = "雙重啄擊"
    override val dmgList: List<Int> = listOf((nowMonster.damage*1.5* Random.nextDouble(0.8, 1.0)).toInt())
}