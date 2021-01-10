package com.pactprovider.pactprovider

import au.com.dius.pact.provider.junit.target.HttpTarget
import au.com.dius.pact.provider.junitsupport.Provider
import au.com.dius.pact.provider.junitsupport.State
import au.com.dius.pact.provider.junitsupport.loader.PactBroker
import au.com.dius.pact.provider.junitsupport.target.TestTarget
import au.com.dius.pact.provider.spring.SpringRestPactRunner
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@RunWith(SpringRestPactRunner::class)
@Provider("user-provider-service")
@PactBroker(
        host = "localhost",
        port = "80",
        scheme = "http",
        consumers = ["user-consume-service"],
)
@SpringBootTest(classes = [PactproviderApplication::class], webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, properties = ["server.port=8080"])
@ActiveProfiles("test")
class UserServiceProviderTests {
    @TestTarget
    val target: HttpTarget = HttpTarget("localhost", 8080)

    @MockkBean
    lateinit var userService: UserService

    @Before
    fun setup() {
        System.setProperty("pact.verifier.publishResults", "true")
    }

    @Test
    @State("a user is present")
    fun `should have a customer`() {
        every { userService.getUser() } returns mapOf(
                "name" to "someName",
                "lastName" to "someLastName",
                "age" to "22"
        )
    }
}
