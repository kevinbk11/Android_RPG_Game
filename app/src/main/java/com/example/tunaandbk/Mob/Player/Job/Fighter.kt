package com.example.tunaandbk.Mob.Player.Job;

import com.example.tunaandbk.Mob.Player.Player
import kotlin.math.pow

class Fighter(name:String,acc:String): Player(name,acc) {
    override var account = acc
    override var job="Fighter"
    override var HP=500
    override var MP=100
    override var FullHP=500
    override var FullMP=100
    override var Damage=10.0
    override var speed=1.0
    override var LV=1
    override var FullEXP: Double =150.0
    override var EXP: Double =0.0

    override var Money=0

    var BasicStr: Double=0.0
    override fun levelup() {
        super.levelup()
        println("LEVEL UP!")
        FullHP=500+(LV-1)*180
        FullMP=100+(LV-1)*50
        HP=FullHP
        MP=FullMP
        BasicStr=LV*2.5
        this.save()
        //Damage=(BasicStr+hand!!.Damage).toInt()
    }
}
