package com.example.tunaandbk

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tunaandbk.Mob.Monster.*
import com.example.tunaandbk.System.*
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.showCheckFight


class ZoomInMap : AppCompatActivity(),GetResource {

    var dialog: AlertDialog?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom_in_map)
        val map = intent.getStringExtra("map")
        setContentView(getXml(map!!)!!)
        val builder = AlertDialog.Builder(this)
        val inflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        dialog = builder.create()
        dialog!!.showCheckFight()
        dialog!!.hide()
    }
    fun cancel(view:View)
    {
        dialog!!.hide()
        nowMonster= NullMonster
    }
    fun ok(view:View)
    {
        dialog!!.hide()
        Log.v("test",nowMonster.name)
        nowMonster=NullMonster
        val intent= Intent(this@ZoomInMap,FightingPage::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
    }

    fun turnTurnBird(view: View){nowMonster= TurnTurnBird();dialog!!.show()}
    fun littleStone(view:View){nowMonster = LittleStone();dialog!!.show()}
}