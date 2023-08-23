package com.example.kotlinstarter.entity

import com.example.kotlinstarter.dto.UserUpdateDto
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@Entity
@Table(name = "users")
class User(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    val id: Long = 0L,

    @Column(unique = true)
    var email: String,

    var name: String,

    var phone: String? = null,

    @Column(name = "created_at")
    @CreatedDate
    val createdAt: LocalDateTime? = LocalDateTime.now(),

    @Column(name = "updated_at")
    @LastModifiedDate
    val updatedAt: LocalDateTime? = LocalDateTime.now(),
) {
    fun updateInfo(userUpdateDto: UserUpdateDto) {
        email = userUpdateDto.email ?: email
        name = userUpdateDto.name ?: name
        phone = userUpdateDto.phone ?: phone
    }
}
