package com.example.tunaandbk

import android.content.Intent
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tunaandbk.System.FileReadOrWrite
import com.example.tunaandbk.System.UIExtension
import com.example.tunaandbk.System.activityList
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.view.*

class Login : AppCompatActivity(),FileReadOrWrite, UIExtension {
    override fun onBackPressed() {
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        register.paintFlags= Paint.UNDERLINE_TEXT_FLAG
        window.hideBar()
        activityList.add(this)
        ok.setScaleAnimation(resources,packageName)
    }

    fun login(view: View)
    {
        if(account.text.toString()==""||(password.text.toString()==""))
        {
            Toast.makeText(this,"輸入不可為空!",Toast.LENGTH_SHORT).show()
            return
        }
        val db = Firebase.firestore
        db.collection("users").document(account.text.toString()).get().addOnSuccessListener {
                user->
            if(user.data!=null)
            {
                val acc = account.text.toString()
                val pw = password.text.toString()
                val ud = user.data!!
                if(ud["account"]==acc&&ud["password"]==pw)
                {
                    if(ud["playerData"]!=null)
                    {

                        if(!ud["online"].toString().toBoolean())
                        {
                            Toast.makeText(this,"此帳號目前正在使用中!",Toast.LENGTH_SHORT).show()
                        }
                        else
                        {
                            rebuildUserData(ud["playerData"] as HashMap<String,Any?>)
                            db.collection("users").document(acc).update("online",true).addOnSuccessListener {
                                Toast.makeText(this,"歡迎回來,$acc",Toast.LENGTH_SHORT).show()
                                Thread{
                                    val intent = Intent(this@Login,GameMainPage::class.java)
                                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                                    startActivity(intent)
                                }.start()
                            }
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
                else Toast.makeText(this,"帳號或密碼錯誤",Toast.LENGTH_SHORT).show()
            }
            else Toast.makeText(this,"此使用者不存在",Toast.LENGTH_SHORT).show()
        }
        db.clearPersistence()
    }
    fun toRegister(view:View)
    {
        val intent = Intent(this@Login, Register::class.java)
        val bundle = Bundle()
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        bundle.putString("account", account.text.toString())
        bundle.putString("password  ", password.text.toString())
        intent.putExtras(bundle)
        startActivity(intent)
    }
}