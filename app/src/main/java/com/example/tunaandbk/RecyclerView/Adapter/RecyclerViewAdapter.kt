package com.example.tunaandbk.RecyclerView.Adapter

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.tunaandbk.FightingPage
import com.example.tunaandbk.GameMainPage
import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.R
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import kotlinx.android.synthetic.main.page2_layout.view.*
import kotlinx.android.synthetic.main.skill_recyclerview_layout.view.*

class RecyclerViewAdapter(private val nowContext:AppCompatActivity, var list: List<Skill>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    inner class ViewHolder( view: View) : RecyclerView.ViewHolder(view) {
        val btn= view.b
        val textBox = view.t
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.skill_recyclerview_layout, parent, false)
        val holder=ViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val skillName = list[position].name
        val btn=holder.btn
        val tB=holder.textBox
        tB.text="測試"
        btn.text=skillName
        btn.setOnClickListener{
            player!!.skillList[position].use()
            if(nowMonster.hp<=0.0)
            {
                nowContext.onBackPressed()
                player!!.save()
            }
            nowMonster.attack()
            if(player!!.HP<=0.0)
            {
                player!!.HP=player!!.FullHP
                player!!.save()
            }

        }
    }

    override fun getItemCount(): Int {
        return list.size
    }


}