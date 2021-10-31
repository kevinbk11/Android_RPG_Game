package com.example.tunaandbk.System

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import androidx.core.graphics.drawable.toBitmap
import com.example.tunaandbk.Item.Equipment.Hand.Fighter.StoneSword
import com.example.tunaandbk.Item.Equipment.Hand.Fighter.WoodSword
import com.example.tunaandbk.Mob.Monster.Monster
import com.example.tunaandbk.Mob.Monster.NullMonster
import com.example.tunaandbk.Mob.Monster.TurnTurnBird
import com.example.tunaandbk.Mob.Player.Player


var player: Player? = null
var activityList= mutableListOf<Activity>()
var nowMonster: Monster = NullMonster
val itemMap=mapOf(
    "木劍" to WoodSword,
    "石劍" to StoneSword,
)
val monsterMap=mapOf<String, Monster>(
    "轉轉鳥" to TurnTurnBird()
)
var r=0
var g=0
var b=0
