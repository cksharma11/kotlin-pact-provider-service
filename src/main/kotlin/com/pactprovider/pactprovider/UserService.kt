package com.pactprovider.pactprovider

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserService {
    @GetMapping("/user")
    fun getUser(): Map<String, String> {
        return mapOf(
                "name" to "Priyanka",
                "lastName" to "Chopra",
                "age" to "22"
        )
    }
}