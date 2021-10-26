package com.example.tunaandbk.Mob.Skill.MonsterSkill

import com.example.tunaandbk.Mob.Skill.Skill
import kotlin.random.Random

class BirdAttack(val basicDamage:Double): Skill() {
    override val name = "雙重啄擊"
    override fun use():Double{
        return basicDamage*1.5* Random.nextDouble(0.8, 1.0)
    }
}