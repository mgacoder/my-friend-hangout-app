package com.magapps.myfriendshangoutapp

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.magapps.myfriendshangoutapp.databinding.ActivityMainBinding

interface LoginCallBack<T> {
    fun callback(data: T)
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        isLoggedIn(object : LoginCallBack<Boolean> {
            override fun callback(data: Boolean) {
                if (data) {
                    //goToFriendsHangoutPage()
                    Toast.makeText(applicationContext, "WE did it!", Toast.LENGTH_LONG).show()
                } else {
                    //goToLoginPage()
                    val intent = Intent(applicationContext, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
        })
    }

    private fun goToLoginPage() {
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }

    private fun goToFriendsHangoutPage() {
        Toast.makeText(this, "WE did it!", Toast.LENGTH_LONG).show()
    }

    private fun isLoggedIn(loginCallback: LoginCallBack<Boolean>){
        val sp = applicationContext.getSharedPreferences("Username", MODE_PRIVATE)
        val username: String? = sp.getString("username", null)
        val reference = FirebaseDatabase.getInstance().getReference("Users").child(username.toString())
        var isLoggedIn = false
        reference.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.hasChild("loggedIn")){
                    isLoggedIn = snapshot.child("loggedIn").value as Boolean
                    loginCallback.callback(isLoggedIn)
                }
            }


            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
        println("return $isLoggedIn")
    }
}



