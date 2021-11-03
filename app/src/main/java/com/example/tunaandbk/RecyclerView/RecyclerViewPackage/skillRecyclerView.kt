package com.example.tunaandbk.RecyclerView.RecyclerViewPackage

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tunaandbk.FightingPage
import com.example.tunaandbk.Mob.Skill.Skill
import com.example.tunaandbk.R
import com.example.tunaandbk.RecyclerView.Adapter.RecyclerViewAdapter
import com.example.tunaandbk.System.player

class skillRecyclerView(val a:AppCompatActivity,val RV:RecyclerView) {
    fun build(context: Context)
    {
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val adapter = RecyclerViewAdapter(a,player!!.skillList)
        RV.layoutManager = layoutManager
        RV.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
        RV.adapter=adapter
    }
}