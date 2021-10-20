package com.example.tunaandbk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.UiThread
import com.example.tunaandbk.R
import com.example.tunaandbk.System.FileReadOrWrite
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity(),FileReadOrWrite {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
    fun login(view: View)
    {
        val db = Firebase.firestore
        db.collection("users").document(account.text.toString()).get().addOnSuccessListener {
            user->
            Log.v("testtest",user.toString())
            if(user.data!=null)
            {
                val acc = account.text.toString()
                val pw = password.text.toString()
                val ud = user.data!!
                if(ud["account"]==acc&&ud["password"]==pw)
                {
                    Thread{
                        Log.v("??","已登入$acc")
                        rebuildUserData(acc)
                        Thread.sleep(1000)
                        runOnUiThread{Toast.makeText(this,"歡迎回來,$acc",Toast.LENGTH_SHORT).show()}
                        val intent = Intent(this@Login,GameMainPage::class.java)
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        startActivity(intent)
                    }.start()
                }
                else
                {
                    Toast.makeText(this,"帳號或密碼錯誤",Toast.LENGTH_SHORT).show()
                }
            }
            else
            {
                val intent = Intent(this@Login,CreatePlayer::class.java)
                val bundle = Bundle()
                bundle.putString("account",account.text.toString())
                bundle.putString("password",password.text.toString())
                intent.putExtras(bundle)
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }
        }
        /*db.collection("users").get().addOnSuccessListener {
            result ->
            for(user in result)
            {

            }
        }*/
        /*Thread{
            Thread.sleep(2000)
            if(!find)
            {

            }
            else
            {

            }

        }.start()*/
    }
}