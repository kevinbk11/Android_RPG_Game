package com.example.tunaandbk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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
        val db = Firebase.firestore
        var find:Boolean=false
        db.collection("users").get().addOnSuccessListener{
                result ->
            for(user in result)
            {
                if(user.data["account"]==name.text.toString())
                {
                    find=true
                    break
                }
            }
        }.addOnCompleteListener {
            if(!find)
            {
                createUserData(account!!,password!!,name.text.toString(),jobPager)
                Thread{
                    Thread.sleep(1500)
                    rebuildUserData(name.text.toString())
                }.start()
            }
            else
            {
                Thread{
                    rebuildUserData(name.text.toString())
                    Thread.sleep(2000)
                    player!!.put(itemMap["木劍"],1)
                    player!!.put(itemMap["石劍"],1)
                    player!!.put(itemMap["木劍"],1)
                    player!!.save()
                    Log.v("test",player!!.bag["equipment"]!![0].count.toString())
                }.start()
            }
        }
    }
}