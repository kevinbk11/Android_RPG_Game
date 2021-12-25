package com.example.tunaandbk.Mob.Skill.MonsterSkill

import android.util.Log
import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlin.random.Random

class BirdAttack: Skill() {
    override val name = "雙重啄擊"
    override fun use(dmgList:MutableList<Int>):List<Int> {
        for(i in 0..1)
        {
            dmgList+=((nowMonster.damage* Random.nextDouble(0.5, 0.7)).toInt())
        }
        super.use(dmgList)
        return dmgList
    }
}