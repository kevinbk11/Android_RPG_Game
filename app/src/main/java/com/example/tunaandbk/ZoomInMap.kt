package com.example.tunaandbk

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tunaandbk.Mob.Monster.LittleStone
import com.example.tunaandbk.Mob.Monster.Monster
import com.example.tunaandbk.Mob.Monster.NullMonster
import com.example.tunaandbk.Mob.Monster.TurnTurnBird
import com.example.tunaandbk.System.getXml
import com.example.tunaandbk.System.nowMonster

class ZoomInMap : AppCompatActivity() {

    var dialog: AlertDialog?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom_in_map)

        val map = intent.getStringExtra("map")
        setContentView(getXml(map!!)!!)
        val builder = AlertDialog.Builder(this)
        val inflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialoglayout =  inflater.inflate(R.layout.fight_recheck,null)
        builder.setView(dialoglayout)
        dialog = builder.create()
        dialog!!.window!!.setBackgroundDrawableResource(android.R.color.transparent)
    }
    fun cancel(view:View)
    {
        dialog!!.hide()
        nowMonster=NullMonster
    }
    fun ok(view:View)
    {
        dialog!!.hide()
        Log.v("test",nowMonster.name)
        /*val intent= Intent(this@ZoomInMap,FightPage::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)*/
    }

    fun turnTurnBird(view: View){nowMonster= TurnTurnBird();dialog!!.show()}
    fun littleStone(view:View){nowMonster = LittleStone();dialog!!.show()}
}