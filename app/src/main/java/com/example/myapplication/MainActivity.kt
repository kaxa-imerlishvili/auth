package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    lateinit var loginEmail : EditText
    lateinit var loginPassword : EditText
    lateinit var logInButton : Button
    lateinit var loginRegisterButton : Button
    lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loginEmail = findViewById(R.id.logInEmailEditText)
        loginPassword = findViewById(R.id.LogInPasswordEditText)
        logInButton = findViewById(R.id.logInButton)
        loginRegisterButton = findViewById(R.id.loginRegisterButton)
        mAuth = FirebaseAuth.getInstance()

        loginRegisterButton.setOnClickListener{
            startActivity(Intent(this, registerActivity::class.java))
        }



        logInButton.setOnClickListener {
            val email = loginEmail.text.toString()
            val password = loginPassword.text.toString()
            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
            }else{

                mAuth.signInWithEmailAndPassword(email,password)
                    .addOnCompleteListener {
                        if(it.isSuccessful){
                        startActivity(Intent(this,UserActivity::class.java))
                        }else Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                    }



            }

        }


    }
}