package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var edtemail: EditText
    private lateinit var edtpassword: EditText
    private lateinit var Buttonlogin: Button
    private lateinit var Buttonsignup: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)
        supportActionBar?.hide()
        mAuth = FirebaseAuth.getInstance()

        edtemail = findViewById(R.id.edt_email)
        edtpassword = findViewById(R.id.edt_password)
        Buttonlogin = findViewById(R.id.buttonlogin)
        Buttonsignup = findViewById(R.id.buttonsignin)

        Buttonsignup.setOnClickListener {
            val intent = Intent(this, sign_upp::class.java)
            startActivity(intent)
        }
        Buttonlogin.setOnClickListener {
            val email = edtemail.text.toString()
            val password = edtpassword.text.toString()

            login(email, password);
        }


    }

    private fun login(email: String, password: String) {
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // code for logging in user
                    val intent = Intent(this@Login, MainActivity2::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this@Login, "user does not exist", Toast.LENGTH_SHORT).show()
                }


            }
    }
}