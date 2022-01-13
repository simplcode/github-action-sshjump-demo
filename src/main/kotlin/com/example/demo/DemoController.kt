package com.example.demo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DemoController {

    @GetMapping("/")
    fun info(): String {
        val hostName = System.getenv("HOSTNAME") ?: "Unknown"

        return "Hello from $hostName!"
    }
}