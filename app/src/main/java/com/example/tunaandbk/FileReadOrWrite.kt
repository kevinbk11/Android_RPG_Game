package com.example.tunaandbk

import android.content.res.Resources
import android.util.Log
import com.example.tunaandbk.Item.Item
import com.example.tunaandbk.Pager.ViewPagerPackage.JobPager
import com.example.tunaandbk.Player.Job.Fighter
import com.example.tunaandbk.Player.Player
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

interface FileReadOrWrite {
    fun getImageResources(r: Resources, name: String, type: String, p: String?): Int {
        return r.getIdentifier(name, type, p)
    }

    fun addUserToFirebase(user: Map<String, Any>) {
        val db = Firebase.firestore
        db.collection("users").add(user)
    }

    fun rebuildUserData(name: String) {
        val db = Firebase.firestore
        db.collection("users").get().addOnSuccessListener { result ->
            for (user in result) {
                if (user.data["account"] == name) {
                    val p = user.data["playerData"] as Map<*, *>
                    if (p["job"] == "Fighter") {
                        player = Fighter(user.data["account"] as String, user.id)
                        with(player!!)
                        {
                            id = p["id"] as String
                            HP = p["hp"].toString().toInt()
                            MP = p["mp"].toString().toInt()
                            FullMP = p["fullMP"].toString().toInt()
                            FullHP = p["fullHP"].toString().toInt()
                            Damage = p["damage"] as Double
                            LV = p["lv"].toString().toInt()
                            FullEXP = p["fullEXP"] as Double
                            EXP = p["exp"] as Double
                            Money = p["money"].toString().toInt()
                        }
                    }
                    break
                }
            }

        }
    }

    fun createUserData(name: String, JobPager: JobPager) {
        when (JobPager.getChoice()) {
            1 -> {
                val user =
                    mapOf<String, Any>(
                        "account" to name,
                        "password" to "bk",
                        "playerData" to Fighter(name, "")
                    )
                addUserToFirebase(user)
            }
            2 -> {
                //TODO
            }
        }
    }

    fun getId(p: Player) {
        val db = Firebase.firestore
        db.collection("users").get().addOnSuccessListener { result ->
            for (user in result) {
                if (p.name == user.data["account"]) {
                    Log.v("test","???????")
                    id=user.id
                    Log.v("test",id!!)
                }
            }
        }
    }
}