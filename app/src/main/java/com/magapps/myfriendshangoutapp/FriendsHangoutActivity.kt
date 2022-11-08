package com.magapps.myfriendshangoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.magapps.myfriendshangoutapp.databinding.ActivityFriendsHangoutBinding

class FriendsHangoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFriendsHangoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFriendsHangoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}