package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class UserActivity : AppCompatActivity() {
    lateinit var userInfo: TextView
    lateinit var logout : Button
    lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        logout = findViewById(R.id.logoutButton)
        userInfo = findViewById(R.id.UserInfo)
        mAuth = FirebaseAuth.getInstance()

        logout.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            mAuth.signOut()
            finish()
        }
        userInfo.text = mAuth.currentUser?.uid



    }
}