package com.example.tunaandbk.Mob.Monster

import com.example.tunaandbk.Mob.Skill.MonsterSkill.BirdAttack

class TurnTurnBird:Monster("轉轉鳥",100,10.0)
{
    init{
        skills.add(BirdAttack(damage))
    }
}