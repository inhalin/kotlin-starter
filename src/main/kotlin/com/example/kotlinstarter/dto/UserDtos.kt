package com.example.kotlinstarter.dto

import com.example.kotlinstarter.entity.User

data class UserDto(
    val userId: Long,
    val email: String,
    val name: String,
    val phone: String?
) {
    constructor(user: User) : this(
        user.id,
        user.email,
        user.name,
        user.phone
    )
}

data class UserInsertDto(
    val email: String,
    val name: String,
    val phone: String?
) {
    fun toEntity(): User = User(email = email, name = name, phone = phone)
}

data class UserUpdateDto(
    val email: String?,
    val name: String?,
    val phone: String?
)