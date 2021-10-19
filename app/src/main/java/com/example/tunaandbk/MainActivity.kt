package com.example.tunaandbk

import android.os.Bundle
import android.text.Editable
import android.util.*
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.tunaandbk.Item.Fighter.Weapon.WoodSword
import com.example.tunaandbk.Item.Item
import com.example.tunaandbk.Pager.ViewPagerPackage.JobPager
import com.example.tunaandbk.Player.Job.Fighter
import com.example.tunaandbk.Player.Player
import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
var player: Player? = null
var id:String?=null
abstract class MainActivity : AppCompatActivity(),FileReadOrWrite {
    lateinit var jobPager: JobPager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        jobPager=JobPager(viewPager)
        /*val bag = user["bag"] as MutableMap<String,MutableMap<String,Int>>
        val equipment = bag["equipment"] as MutableList<Item>
        equipment.add(WoodSword("木劍"))
        addUserToFirebase(user)
        FirebaseApp.initializeApp(this)
        val db = Firebase.firestore
        db.collection("users").get().addOnSuccessListener {
            result ->
            for(user in result)
            {

                if(user.data["account"]=="LoveNyabi")
                {

                    val bag = user.data["bag"] as MutableMap<String,MutableList<HashMap<String,String>>>
                    val eq = bag["equipment"] as MutableList<HashMap<String,String>>
                    for(e in eq)
                    {
                        if(e["name"]=="木劍")
                        {
                            var c = e["count"]!!
                            e["count"] = (c.toInt()+1).toString()
                            db.collection("users").document(user.id).update(FieldPath.of("bag"),bag)
                        }
                        val newItem = itemMap[e["name"]]
                        newItem!!.count=e["count"]!!.toInt()
                        Log.v("test",newItem.count.toString())
                    }

                }
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
                createUserData(name.text.toString(),jobPager)
                Thread{
                    Thread.sleep(1500)
                    rebuildUserData(name.text.toString())
                    Thread.sleep(1500)
                    getId(player!!)
                    Thread.sleep(1500)
                    player!!.id=id!!
                    val db=Firebase.firestore
                    db.collection("users").document(player!!.id).update("playerData",player)
                }.start()
            }
            else
            {
                Thread{
                    rebuildUserData(name.text.toString())
                    Thread.sleep(2000)
                    player!!.levelup()
                    player!!.save()
                }.start()


            }
        }

    }

}



