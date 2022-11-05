package com.magapps.myfriendshangoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.magapps.myfriendshangoutapp.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding
    private lateinit var rootNode: FirebaseDatabase
    private lateinit var reference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegister.setOnClickListener {
            registerUser()
        }

    }

    private fun registerUser() {
        println("we ar in registerUser()")
        val user = User(
            binding.editTextFirstName.text.toString(),
            binding.editTextLastName.text.toString(),
            binding.editTextUsername.text.toString(),
            binding.editTextEmail.text.toString(),
            binding.editTextPassword.text.toString(),
            binding.editTextConfirmPassword.text.toString(),
            true,
            "active"
        )
        println(user.toString())

        rootNode = FirebaseDatabase.getInstance("https://my-friends-hangout-app-default-rtdb.firebaseio.com")
        reference = rootNode.getReference("Users")
        reference.child(user.username).setValue(user)
    }
}