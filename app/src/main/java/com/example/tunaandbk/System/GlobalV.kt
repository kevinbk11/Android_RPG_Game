package com.example.tunaandbk.System

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.graphics.Color
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
import com.example.tunaandbk.Item.Equipment.Hand.Fighter.StoneSword
import com.example.tunaandbk.Item.Equipment.Hand.Fighter.WoodSword
import com.example.tunaandbk.Mob.Monster.Monster
import com.example.tunaandbk.Mob.Monster.NullMonster
import com.example.tunaandbk.Mob.Monster.TurnTurnBird
import com.example.tunaandbk.Mob.Player.Player
import com.example.tunaandbk.Mob.Player.nullPlayer
import com.example.tunaandbk.Mob.Skill.PlayerSkill.SwordAttack
import com.example.tunaandbk.R

var skillPosition = -1
var fighting=Fighting()
var player: Player = nullPlayer
var activityList= mutableListOf<Activity>()
var nowMonster: Monster = NullMonster
var monsterDmgText:List<TextView> = listOf()
var playerDmgText:List<TextView> = listOf()
var fightingButtonList:MutableList<Button> = mutableListOf()
val itemMap=mapOf(
    "木劍" to WoodSword,
    "石劍" to StoneSword,
)
val monsterMap=mapOf(
    "轉轉鳥" to TurnTurnBird()
)
val skillMap=mapOf(
    "重劍劈砍" to SwordAttack()
)
var r=0
var g=0
var b=0
