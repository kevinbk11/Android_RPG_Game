package com.example.tunaandbk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.tunaandbk.Pager.ViewPagerPackage.JobPager
import com.example.tunaandbk.R
import com.example.tunaandbk.System.FileReadOrWrite
import com.example.tunaandbk.System.itemMap
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_create_player.*

class CreatePlayer : AppCompatActivity(),FileReadOrWrite {
    lateinit var jobPager: JobPager
    lateinit var account:String
    lateinit var password:String
    override fun onBackPressed() {
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        account = intent.getStringExtra("account")!!
        password=intent.getStringExtra("password")!!
        jobPager=JobPager(viewPager)
        for(i in 1..2)
        {
            jobPager.addimg(getImageResources(resources,"b$i","mipmap",packageName))
        }
        jobPager.buildViewPage2()
        Thread{
            while(true)
            {
                Log.v("test", jobPager.getChoice().toString())
                Thread.sleep(1000)
            }
        }
    }
    fun ok(view: View)
    {
        if(name.text.toString()=="")
        {
            Toast.makeText(this,"輸入不可為空!", Toast.LENGTH_SHORT).show()
            return
        }
        createUserData(account,password,name.text.toString(),jobPager)
        Thread{
            Thread.sleep(1500)
            val intent = Intent(this@CreatePlayer,GameMainPage::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }.start()
    }
}