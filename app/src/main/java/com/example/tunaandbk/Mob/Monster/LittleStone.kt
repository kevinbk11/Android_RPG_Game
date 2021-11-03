package com.example.tunaandbk.Mob.Monster

import com.example.tunaandbk.Mob.Skill.MonsterSkill.BirdAttack
import com.example.tunaandbk.Mob.Skill.MonsterSkill.NormalAttack.NormalAttack1
import kotlin.random.Random

class LittleStone:Monster("小石怪",100,10.0,0.8)
{
    override fun attack()
    {
        val flag = Random.nextInt(1, 101)
        when(flag) {
            in 0..80-> NormalAttack1().use()
            in 81..100-> BirdAttack().use()
            else-> NormalAttack1().use()
        }
    }
}