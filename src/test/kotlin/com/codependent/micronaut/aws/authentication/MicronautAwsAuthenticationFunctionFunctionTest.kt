package com.codependent.micronaut.aws.authentication

import io.micronaut.context.ApplicationContext
import io.micronaut.runtime.server.EmbeddedServer
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions.assertEquals


class MicronautAwsAuthenticationFunctionFunctionTest: Spek({

    describe("micronaut-aws-authentication-function function") {
        val server = ApplicationContext.run(EmbeddedServer::class.java)
        val client = server.applicationContext.getBean(MicronautAwsAuthenticationFunctionClient::class.java)

        it("should return 'micronaut-aws-authentication-function'") {
            assertEquals(client.index().blockingGet(), "micronaut-aws-authentication-function")
        }

        afterGroup {
            server.stop()
        }
    }
})
