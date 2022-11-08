package com.magapps.myfriendshangoutapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.commit
import com.magapps.myfriendshangoutapp.databinding.ActivityFriendsHangoutBinding
import com.google.android.material.navigation.NavigationBarView
import com.google.firebase.database.FirebaseDatabase

class FriendsHangoutActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener{

    private lateinit var binding: ActivityFriendsHangoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFriendsHangoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNav.setOnItemSelectedListener(this)
    }

    private fun onSelfClicked() {
        supportFragmentManager.commit{
            replace(R.id.fragment_container_view_frame, UserFragment())
        }
    }

    private fun onFriendsClicked() {
        supportFragmentManager.commit{
            replace(R.id.fragment_container_view_frame, FriendsListFragment())
        }
    }

    override fun onNavigationItemSelected(item: MenuItem) = when(item.itemId){
            R.id.nav_friends_list ->{
                onFriendsClicked()
                true
            }
            R.id.nav_my_status ->{
                onSelfClicked()
                true
            }
            else -> false
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){
        R.id.logout ->{
            logoutUser()
            true
        }
        else -> false
    }

    private fun logoutUser(){
        val sharedPreference = applicationContext.getSharedPreferences("Username", MODE_PRIVATE)
        val username: String? = sharedPreference.getString("username", null)
        val reference = FirebaseDatabase.getInstance().getReference("Users").child(username.toString())
        reference.child("loggedIn").setValue(false)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }


}


