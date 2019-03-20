package com.codependent.micronaut.aws.authentication

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("com.codependent.micronaut.aws.authentication")
                .mainClass(Application.javaClass)
                .start()
    }
}
