package com.pactprovider.pactprovider

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserService {
    @GetMapping("/user")
    fun getOrder(): Map<String, String> {
        return mapOf(
                "name" to "chandan",
                "lastName" to "Sharma",
                "age" to "22"
        )
    }
}