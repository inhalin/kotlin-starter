package com.example.kotlinstarter.repository

import com.example.kotlinstarter.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, Long>
