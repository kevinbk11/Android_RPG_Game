package com.example.tunaandbk.Mob.Monster
import com.example.tunaandbk.Mob.Skill.MonsterSkill.BirdAttack
import com.example.tunaandbk.Mob.Skill.MonsterSkill.NormalAttack.NormalAttack1
import com.example.tunaandbk.Mob.Skill.Skill
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class TurnTurnBird:Monster("轉轉鳥",100,10.0,1.2,10,30,listOf()) {
    init{skills.add(NormalAttack1())
        skills.add(BirdAttack())}
    override fun attack():List<Int>
    {
        val flag = nextInt(1,101)
        return when(flag) {
            in 0..80-> NormalAttack1().use()
            in 81..100->  BirdAttack().use()
            else-> NormalAttack1().use()
        }
    }

}