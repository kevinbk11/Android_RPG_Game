package com.example.tunaandbk.System

import android.util.Log
import com.example.tunaandbk.Pager.ViewPagerPackage.JobPager
import com.example.tunaandbk.Mob.Player.Job.Fighter
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
interface FileReadOrWrite {
    fun addUserToFirebase(user: HashMap<String, Any>) {
        val db = Firebase.firestore
        db.collection("users").document(user["account"].toString()).set(user)
    }

    fun rebuildUserData(p: HashMap<String,Any?>) {
        if (p["job"] == "Fighter") {
            player = Fighter(p["name"].toString(),p["account"].toString())
            with(player)
            {
                account = p["account"].toString()
                hp = p["hp"].toString().toInt()
                mp = p["mp"].toString().toInt()
                fullMP = p["fullMP"].toString().toInt()
                fullHP = p["fullHP"].toString().toInt()
                damage = p["damage"].toString().toDouble()
                lv = p["lv"].toString().toInt()
                fullEXP = p["fullEXP"].toString().toDouble()
                exp = p["exp"].toString().toDouble()
                money = p["money"].toString().toInt()
                val b = p["bag"] as MutableMap<String, ArrayList<HashMap<String, Any>>>
                val eq = b["equipment"]!!
                val co = b["consume"]!!
                val an = b["another"]!!
                for(i in p["skillList"] as ArrayList<HashMap<String,String>>)
                {
                    player.learnSkill(skillMap[i["name"].toString()]!!)
                }
                for (i in co.filter{it["name"]!="none"}) {
                    getItem(itemMap[i["name"]],i["count"]!!.toString().toInt())
                }
                for (i in eq.filter{it["name"]!="none"}) {
                    getItem(itemMap[i["name"]], i["count"]!!.toString().toInt())
                }
                for (i in an.filter{it["name"]!="none"}) {
                    getItem(itemMap[i["name"]], i["count"]!!.toString().toInt())
                }
            }
        }
    }
    fun createUserData(account:String,password:String,name: String, JobPager: JobPager) {
        when (JobPager.getChoice()) {
            1 -> {
                val user =
                    hashMapOf<String, Any>(
                        "account" to account,
                        "password" to password,
                        "online" to true,
                        "playerData" to Fighter(name,account)
                    )
                addUserToFirebase(user)
            }
            2 -> {
                //TODO
            }
        }
        player=Fighter(name,account)
    }
}
