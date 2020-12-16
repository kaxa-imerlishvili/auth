package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class registerActivity : AppCompatActivity() {
    lateinit var registerEmail : EditText
    lateinit var registePassword : EditText
    lateinit var registerButton : Button
    lateinit var mAuth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerEmail = findViewById(R.id.registerEmailTextEdit)
        registePassword = findViewById(R.id.registerPasswordEditText)
        registerButton = findViewById(R.id.registerButton)
        mAuth = FirebaseAuth.getInstance()




        registerButton.setOnClickListener {
            val email = registerEmail.text.toString()
            val password = registePassword.text.toString()

            if(email.isEmpty() || password.isEmpty()){
                Toast.makeText( this,"Error", Toast.LENGTH_SHORT).show()
            } else {
                    mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener {
                            if(it.isSuccessful){
                                startActivity(Intent(this,MainActivity::class.java))
                            }
                            finish()
                        }
            }
        }





    }




}