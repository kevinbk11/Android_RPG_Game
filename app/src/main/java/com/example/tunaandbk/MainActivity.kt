package com.example.tunaandbk

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tunaandbk.Player.Player
class MainActivity : AppCompatActivity() {
    override fun onBackPressed() {
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val intent = Intent(this@MainActivity,Login::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        startActivity(intent)
    }

}