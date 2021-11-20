package com.example.tunaandbk.Mob.Monster

import com.example.tunaandbk.Mob.Skill.MonsterSkill.BirdAttack
import com.example.tunaandbk.Mob.Skill.MonsterSkill.NormalAttack.NormalAttack1
import com.example.tunaandbk.Mob.Skill.MonsterSkill.StoneAttack
import kotlin.random.Random

class LittleStone:Monster("小石怪",100,10.0,0.8,10,30,listOf())
{
    override fun attack():List<Int>
    {
        val flag = Random.nextInt(1, 101)
        return when(flag) {
            in 0..80-> NormalAttack1().use()
            in 81..100->  StoneAttack().use()
            else-> NormalAttack1().use()
        }
    }
}