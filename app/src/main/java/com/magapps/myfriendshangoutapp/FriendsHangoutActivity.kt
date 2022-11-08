package com.magapps.myfriendshangoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.commit
import com.magapps.myfriendshangoutapp.databinding.ActivityFriendsHangoutBinding
import com.google.android.material.navigation.NavigationBarView

class FriendsHangoutActivity : AppCompatActivity(), NavigationBarView.OnItemReselectedListener,
    NavigationBarView.OnItemSelectedListener {

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

    override fun onNavigationItemSelected(item: MenuItem) =
        when(item.itemId){
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

    override fun onNavigationItemReselected(item: MenuItem) {
        TODO("Not yet implemented")
    }


}


