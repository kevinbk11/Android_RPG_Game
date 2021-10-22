package com.example.tunaandbk

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val acc = intent.getStringExtra("account")
        val pw = intent.getStringExtra("password")
        register_account_textView.setText(acc)
        register_password_textView.setText(pw)
    }
    fun register(view: View)
    {
        val acc = register_account_textView.text.toString()
        val pw = register_password_textView.text.toString()
        val db = Firebase.firestore
        db.collection("users").document(acc).get().addOnSuccessListener {
            result->
            if(result.data!=null) Toast.makeText(this,"此帳號已有人使用",Toast.LENGTH_SHORT).show()
            else
            {
                val intent = Intent(this@Register,CreatePlayer::class.java)
                val bundle = Bundle()
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                bundle.putString("account",acc)
                bundle.putString("password",pw)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }

}