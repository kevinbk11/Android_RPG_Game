package com.example.tunaandbk.System

import com.example.tunaandbk.Item.Equipment.Hand.Fighter.StoneSword
import com.example.tunaandbk.Item.Equipment.Hand.Fighter.WoodSword
import com.example.tunaandbk.Mob.Monster.Monster
import com.example.tunaandbk.Mob.Monster.TurnTurnBird
import com.example.tunaandbk.Mob.Player.Player

var player: Player? = null
val itemMap=mapOf(
    "木劍" to WoodSword,
    "石劍" to StoneSword
)
val monsterMap=mapOf<String, Monster>(
    "轉轉鳥" to TurnTurnBird
)
