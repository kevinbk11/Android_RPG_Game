package com.example.tunaandbk.System

import com.example.tunaandbk.Item.Fighter.Weapon.StoneSword
import com.example.tunaandbk.Item.Fighter.Weapon.WoodSword
import com.example.tunaandbk.Player.Player

var player: Player? = null
val itemMap=mapOf(
    "木劍" to WoodSword("木劍"),
    "石劍" to StoneSword("石劍")
)