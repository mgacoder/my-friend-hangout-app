package com.magapps.myfriendshangoutapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.magapps.myfriendshangoutapp.databinding.FragmentFriendsListBinding

class FriendsListFragment : Fragment() {

    private lateinit var binding: FragmentFriendsListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFriendsListBinding.inflate(inflater, container, false)
        return binding.root
    }

}