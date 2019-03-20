package com.codependent.micronaut.aws.authentication

import com.auth0.jwt.algorithms.Algorithm
import com.codependent.micronaut.aws.authentication.dto.Credentials
import io.micronaut.function.FunctionBean
import java.util.function.Function
import com.auth0.jwt.JWT
import com.codependent.micronaut.aws.authentication.dto.AuthenticationResponse
import org.slf4j.LoggerFactory


@FunctionBean("micronaut-aws-authentication-function")
class MicronautAwsAuthenticationFunction : Function<Credentials, AuthenticationResponse> {

    private val logger = LoggerFactory.getLogger(javaClass)

    override fun apply(t: Credentials): AuthenticationResponse {
        logger.info("Authenticating {} - {}", t.user, t.password)
        return if (t.user == "jose" && t.password == "MyPassword") {
            //HMAC
            val algorithm = Algorithm.HMAC256("secret")
            val token = JWT.create()
                    .withIssuer("MicronautAwsAuthenticationFunction")
                    .withSubject(t.user)
                    .sign(algorithm)
            logger.info("Generated token {}", token)
            AuthenticationResponse(token)
        } else {
            logger.info("Incorrect user/password")
            AuthenticationResponse()
        }
    }

}
