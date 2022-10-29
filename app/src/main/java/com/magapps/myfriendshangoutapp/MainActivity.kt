package com.magapps.myfriendshangoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.magapps.myfriendshangoutapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*for now the first activity to load will be the login page
           if user is logged in it will go to the app an activity
           that I will add later
         */
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)

    }
}