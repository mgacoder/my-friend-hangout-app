package com.magapps.myfriendshangoutapp

import java.io.Serializable

data class User(
    val firstName: String,
    val lastName: String,
    val username: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
    val isLoggedIn: Boolean,
    val status: String
): Serializable{
    override fun toString(): String {
        return """
            $firstName $lastName
            $username
            $email
            $password
            $isLoggedIn
            $status
        """.trimIndent()
    }
}