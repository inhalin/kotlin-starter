package com.example.kotlinstarter.controller

import com.example.kotlinstarter.dto.Message
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class MessageController {
    @GetMapping
    fun index(@RequestParam(defaultValue = "anonymous") name: String): String = "Hello, $name!"

    @GetMapping("/messages")
    fun list(): List<Message> {
        return listOf(
            Message(1, "안녕하세요~"),
            Message(2, "식사 맛있게 하세요!"),
            Message(3, "(퇴근)"),
        )
    }
}