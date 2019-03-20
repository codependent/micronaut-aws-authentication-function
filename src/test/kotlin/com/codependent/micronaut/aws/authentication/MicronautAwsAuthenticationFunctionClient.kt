package com.codependent.micronaut.aws.authentication

import io.micronaut.function.client.FunctionClient
import io.reactivex.Single
import javax.inject.Named

@FunctionClient
interface MicronautAwsAuthenticationFunctionClient {

    @Named("micronaut-aws-authentication-function")
    fun index(): Single<String>

}
