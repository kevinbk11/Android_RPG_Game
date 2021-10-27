package com.example.tunaandbk

import android.app.Activity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tunaandbk.System.FileReadOrWrite

class BigMap : AppCompatActivity(), FileReadOrWrite {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_big_map)
    }
}
