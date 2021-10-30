package com.example.tunaandbk

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tunaandbk.System.getXml

class ZoomInMap : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zoom_in_map)
        val map = intent.getStringExtra("map")
        setContentView(getXml(map!!)!!)
    }
    fun tt(view: View)
    {
        val builder = AlertDialog.Builder(this)
        val inflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val dialoglayout =  inflater.inflate(R.layout.test,null)
        builder.setView(dialoglayout)
        val dialog = builder.create()
        dialog.window!!.setLayout(621,309)
        dialog.show()
    }
}