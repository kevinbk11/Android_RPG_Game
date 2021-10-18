package com.example.tunaandbk

import android.os.Bundle
import android.util.*
import androidx.appcompat.app.AppCompatActivity
import com.example.tunaandbk.Pager.ViewPagerPackage.JobPager
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(),FileReadOrWrite {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val jobPager=JobPager(viewPager)

        /*FirebaseApp.initializeApp(this)
        val db = Firebase.firestore
        val users = hashMapOf<String,String>(
            "account" to "LoveNyabi",
            "password" to "kevinbk11")
        db.collection("users").get().addOnSuccessListener {
            result ->
            for(user in result)
            {
                Log.v("?",user.data.toString())
            }
        }*/


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
}



