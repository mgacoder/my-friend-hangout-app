package com.magapps.myfriendshangoutapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.magapps.myfriendshangoutapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var reference: DatabaseReference
    private lateinit var sharedPreference: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewRegister.setOnClickListener {
            val intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
        }

        binding.textViewForgotPassword.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }

        binding.buttonLogin.setOnClickListener {
            val username = binding.editTextUsername
            val password = binding.editTextPassword
            validateUser(username.text.toString(), password.text.toString())
        }
    }

    private fun validateUser(username:String, password:String) {
        reference = FirebaseDatabase.getInstance().getReference("Users")
        reference.child(username).get().addOnSuccessListener {
            if(it.exists()){
                if(it.child("password").value?.equals(password) == true){
                    /*TODO make sure that db isLoggedIn is set to true when
                        username exists and password matches
                     */

                    sharedPreference = getSharedPreferences("Username", Context.MODE_PRIVATE)
                    val editor: SharedPreferences.Editor = sharedPreference.edit()
                    editor.putString("username", username)
                    editor.apply()

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                }else{
                    Toast.makeText(this, "Incorrect Password", Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this, "Incorrect Username", Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_LONG).show()
        }
    }
}