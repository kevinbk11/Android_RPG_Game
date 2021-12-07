package com.example.tunaandbk.RecyclerView.Adapter

import android.content.Context
import android.content.Intent
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.tunaandbk.FightingPage
import com.example.tunaandbk.GameMainPage
import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.R
import com.example.tunaandbk.System.fighting
import com.example.tunaandbk.System.nowMonster
import com.example.tunaandbk.System.player
import com.example.tunaandbk.System.skillPosition
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.page2_layout.view.*
import kotlinx.android.synthetic.main.skill_recyclerview_layout.view.*

class RecyclerViewAdapter(private val nowContext:AppCompatActivity, var list: List<Skill>):RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    val skillButtonList=mutableListOf<Button>()
    inner class ViewHolder( view: View) : RecyclerView.ViewHolder(view) {
        val btn = view.t
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.skill_recyclerview_layout, parent, false)
        val holder=ViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val skillName = list[position].name
        val btn = holder.btn
        skillButtonList+=btn
        btn.text=skillName
        btn.setOnClickListener{
            skillPosition=position
            fighting.startThisRound()
        }
    }

    override fun getItemCount(): Int { return list.size }
}