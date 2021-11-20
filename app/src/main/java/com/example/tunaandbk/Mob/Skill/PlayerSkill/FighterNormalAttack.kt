package com.example.tunaandbk.Mob.Skill.PlayerSkill

import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.System.monsterDmgText
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlin.random.Random

class FighterNormalAttack: Skill() {
    override val dmgList = listOf(((player.damage)* Random.nextDouble(0.8, 1.2)).toInt())
}