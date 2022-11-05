package com.magapps.myfriendshangoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.magapps.myfriendshangoutapp.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonRegister.setOnClickListener {
            registerUser()
        }

    }

    private fun registerUser() {
        val user = User(
            binding.editTextFirstName.text.toString(),
            binding.editTextLastName.text.toString(),
            binding.editTextEmail.text.toString(),
            binding.editTextPassword.text.toString(),
            binding.editTextConfirmPassword.text.toString(),
            true,
            "active"
        )
    }
}