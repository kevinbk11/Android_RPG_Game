package com.example.tunaandbk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tunaandbk.System.player
import kotlinx.android.synthetic.main.activity_game_main_page.*

class GameMainPage : AppCompatActivity() {
    override fun onBackPressed() {
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_main_page)
        player!!.levelup()
        textView.setText(player!!.name)
    }
}