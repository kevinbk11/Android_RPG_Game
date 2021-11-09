package com.example.tunaandbk.Mob.Player.Job;

import com.example.tunaandbk.Mob.Player.Player

class Fighter(name:String,acc:String): Player(name,acc) {
    override var account = acc
    override var job="Fighter"
    override var hp=500
    override var mp=100
    override var fullHP=500
    override var fullMP=100
    override var damage=10.0
    override var speed=1.0
    override var lv=1
    override var fullEXP: Double =150.0
    override var exp: Double =0.0

    override var money=0

    var BasicStr: Double=0.0
    override fun levelup() {
        super.levelup()
        println("LEVEL UP!")
        fullHP=500+(lv-1)*180
        fullMP=100+(lv-1)*50
        hp=fullHP
        mp=fullMP
        BasicStr=lv*2.5
        this.save()
        //Damage=(BasicStr+hand!!.Damage).toInt()
    }
}
