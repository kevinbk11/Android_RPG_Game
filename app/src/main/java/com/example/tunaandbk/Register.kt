package com.example.tunaandbk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.tunaandbk.System.UIExtension
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity(), UIExtension {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        window.hideBar()
        val acc = intent.getStringExtra("account")
        val pw = intent.getStringExtra("password")
        register_account_textView.setText(acc)
        register_password_textView.setText(pw)
    }
    fun register(view: View)
    {
        if(register_account_textView.text.toString()==""||register_password_textView.text.toString()==""||password_check.text.toString()=="")return
        val acc = register_account_textView.text.toString()
        val pw = register_password_textView.text.toString()
        val db = Firebase.firestore
        if(acc==""||pw==""||password_check.text.toString()=="")
        {
            Toast.makeText(this,"輸入不可為空!",Toast.LENGTH_SHORT).show()
            return
        }
        db.collection("users").document(acc).get().addOnSuccessListener {
            result->
            if(result.data!=null) Toast.makeText(this,"此帳號已有人使用",Toast.LENGTH_SHORT).show()
            else
            {
                if(password_check.text.toString()==register_password_textView.text.toString())
                {
                    val intent = Intent(this@Register,Login::class.java)
                    val user = mapOf<String,Any>(
                        "account" to acc,
                        "password" to pw,
                        "online" to false
                    )
                    db.collection("users").document(acc).set(user).addOnSuccessListener {
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                        Toast.makeText(this,"帳號註冊成功!請再次登入並建立角色",Toast.LENGTH_SHORT).show()
                        startActivity(intent)
                    }

                }
                else
                {
                    Toast.makeText(this,"兩次密碼不一致",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}