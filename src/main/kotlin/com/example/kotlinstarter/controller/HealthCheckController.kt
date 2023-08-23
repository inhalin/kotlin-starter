package com.example.kotlinstarter.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {
    @GetMapping("/api/v1/health/ping")
    fun ping(): String = "pong"
}