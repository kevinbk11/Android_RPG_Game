package com.example.tunaandbk.System

import android.content.res.Resources
import android.util.Log
import com.example.tunaandbk.Pager.ViewPagerPackage.JobPager
import com.example.tunaandbk.Player.Job.Fighter
import com.example.tunaandbk.Player.Player
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
interface FileReadOrWrite {
    fun getImageResources(r: Resources, name: String, type: String, p: String?): Int {
        return r.getIdentifier(name, type, p)
    }

    fun addUserToFirebase(user: Map<String, Any>) {
        val db = Firebase.firestore
        db.collection("users").document(user["account"].toString()).set(user)
    }

    fun rebuildUserData(p: Map<String,Any?>): Player {
        Log.v("ttt",p["job"].toString())
        if (p["job"] == "Fighter") {
            player = Fighter(p["name"].toString(),p["account"].toString())
            with(player!!)
            {
                account = p["account"].toString()
                HP = p["hp"].toString().toInt()
                MP = p["mp"].toString().toInt()
                FullMP = p["fullMP"].toString().toInt()
                FullHP = p["fullHP"].toString().toInt()
                Damage = p["damage"] as Double
                LV = p["lv"].toString().toInt()
                FullEXP = p["fullEXP"] as Double
                EXP = p["exp"] as Double
                Money = p["money"].toString().toInt()
                val b = p["bag"] as MutableMap<String, ArrayList<HashMap<String, Any>>>
                val eq = b["equipment"]!!
                val co = b["consume"]!!
                val an = b["another"]!!
                for (i in eq.indices) {
                    if (eq[i]["name"] != "none") {
                        put(itemMap[eq[i]["name"]], eq[i]["count"]!!.toString().toInt())
                    }
                }
                for (i in co.indices) {
                    if (co[i]["name"] != "none") {
                        put(itemMap[co[i]["name"]], co[i]["count"]!!.toString().toInt())
                    }
                }
                for (i in an.indices) {
                    if (an[i]["name"] != "none") {
                        put(itemMap[an[i]["name"]], an[i]["count"]!!.toString().toInt())
                    }
                }
            }
        }
        return player!!
    }
    fun createUserData(account:String,password:String,name: String, JobPager: JobPager) {
        when (JobPager.getChoice()) {
            1 -> {
                val user =
                    mapOf<String, Any>(
                        "account" to account,
                        "password" to password,
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
