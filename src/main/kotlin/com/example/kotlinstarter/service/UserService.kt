package com.example.kotlinstarter.service

import com.example.kotlinstarter.dto.UserDto
import com.example.kotlinstarter.dto.UserInsertDto
import com.example.kotlinstarter.dto.UserUpdateDto
import com.example.kotlinstarter.entity.User
import com.example.kotlinstarter.repository.UserRepository
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {
    fun listAll(): List<UserDto> {
        return userRepository.findAll().map { user -> UserDto(user) }
    }

    @Transactional
    fun insert(userInsertDto: UserInsertDto): Long? {
        val saved = userRepository.save(userInsertDto.toEntity())
        return saved.id
    }

    fun get(userId: Long): UserDto? {
        val user: User = userRepository.findById(userId).orElseThrow { EntityNotFoundException() }
        return UserDto(user)
    }

    @Transactional
    fun update(userId: Long, userUpdateDto: UserUpdateDto): UserDto {
        val user: User = userRepository.findById(userId).orElseThrow { EntityNotFoundException() }
        user.updateInfo(userUpdateDto)
        return UserDto(user)
    }

    @Transactional
    fun delete(userId: Long) {
        val user: User = userRepository.findById(userId).orElseThrow { EntityNotFoundException() }
        userRepository.delete(user)
    }
}
