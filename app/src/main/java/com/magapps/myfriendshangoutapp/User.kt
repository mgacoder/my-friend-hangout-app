package com.magapps.myfriendshangoutapp

data class User(
    private val firstName: String,
    private val lastName: String,
    private val email: String,
    private val password: String,
    private val confirmPassword: String,
    private val isLoggedIn: Boolean,
    private val status: String
)