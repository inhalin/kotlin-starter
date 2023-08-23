package com.example.kotlinstarter.controller

import com.example.kotlinstarter.dto.UserDto
import com.example.kotlinstarter.dto.UserInsertDto
import com.example.kotlinstarter.dto.UserUpdateDto
import com.example.kotlinstarter.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping
    fun listAll(): List<UserDto> = userService.listAll()

    @PostMapping
    fun insert(@RequestBody userInsertDto: UserInsertDto): ResponseEntity<Long> =
        ResponseEntity.ok(userService.insert(userInsertDto))

    @GetMapping("/{userId}")
    fun get(@PathVariable userId: Long): ResponseEntity<UserDto> =
        ResponseEntity.ok(userService.get(userId))

    @PutMapping("/{userId}")
    fun update(@PathVariable userId: Long, @RequestBody userUpdateDto: UserUpdateDto): ResponseEntity<UserDto> =
        ResponseEntity.ok(userService.update(userId, userUpdateDto))

    @DeleteMapping("/{userId}")
    fun delete(@PathVariable userId: Long): ResponseEntity<Any> {
        userService.delete(userId)
        return ResponseEntity.ok(null)
    }
}