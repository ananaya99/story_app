package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SignUp : AppCompatActivity() {
    private lateinit var edtname: EditText
    private lateinit var edtemail: EditText
    private lateinit var edtpassword: EditText
    private lateinit var Buttonsignup: Button
    private lateinit var mAuth: FirebaseAuth
    private lateinit var mDbRef:DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_upp)
        supportActionBar?.hide()

        edtname = findViewById(R.id.edt_name)
        edtemail = findViewById(R.id.edt_email)
        edtpassword= findViewById(R.id.edt_password)
        Buttonsignup= findViewById(R.id.buttonsignin)
        mAuth= FirebaseAuth.getInstance()

        Buttonsignup.setOnClickListener{
            val name = edtname.text.toString()
            val email = edtemail.text.toString()
            val password = edtpassword.text.toString()

            signUp(name,email,password)
        }


    }
    private fun signUp(name:String,email:String,password:String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                task ->
                if(task.isSuccessful){
                    addusertodatabase(name,email,mAuth.currentUser?.uid!!)

                    val intent = Intent(this@SignUp,MainActivity2::class.java)
                    startActivity(intent)
                }
                else{
                    Toast.makeText(this@SignUp,"Some error occured",Toast.LENGTH_SHORT)

                }
            }
    }
    private fun addusertodatabase(name:String,email:String,uid:String){
mDbRef = FirebaseDatabase.getInstance().getReference()
        mDbRef.child("user").child(uid).setValue(user(name,email,uid))
    }
    }

