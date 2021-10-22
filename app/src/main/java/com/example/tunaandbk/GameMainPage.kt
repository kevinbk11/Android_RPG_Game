package com.example.tunaandbk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.tunaandbk.System.FileReadOrWrite
import com.example.tunaandbk.System.player
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_game_main_page.*

class GameMainPage : AppCompatActivity(),FileReadOrWrite {
    override fun onBackPressed() {
    }

    override fun onStop() {
        super.onStop()
        player!!.online=false
        player!!.save()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game_main_page)
        Log.v("playerInfo",player!!.name)
        player!!.save()
        textView.setText(player!!.name)
    }
}