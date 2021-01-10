package com.pactprovider.pactprovider


import au.com.dius.pact.provider.junitsupport.Provider
import au.com.dius.pact.provider.junitsupport.State
import au.com.dius.pact.provider.junitsupport.loader.PactBroker
import au.com.dius.pact.provider.junitsupport.loader.PactBrokerAuth
import au.com.dius.pact.provider.junitsupport.target.TestTarget
import au.com.dius.pact.provider.spring.SpringRestPactRunner
import au.com.dius.pact.provider.spring.target.SpringBootHttpTarget
import junit.framework.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest

@RunWith(SpringRestPactRunner::class)
@Provider("user-provider-service")
@PactBroker(
        host = "localhost",
        port = "80",
        scheme = "http",
        consumers = ["user-consume-service"],
)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceProviderTests {
    @TestTarget
    val target = SpringBootHttpTarget()

    @Test
    @State("a request to get user")
    fun `should have a customer`() {
        assertTrue(true)
    }
}
