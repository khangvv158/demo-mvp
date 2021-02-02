package com.example.demomvp.data.model

data class User(
    val id: String = "",
    var email: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var avatar: String = ""
)

object UserEntity {
    const val USER = "data"
    const val ID = "id"
    const val EMAIL = "email"
    const val FIRST_NAME = "first_name"
    const val LAST_NAME = "last_name"
    const val AVATAR = "avatar"
}
