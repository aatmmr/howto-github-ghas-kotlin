/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example

import java.util.logging.Logger

val logger: Logger = Logger.getLogger("AppLogger")

class App {
    val greeting: String
        get() {
            return "Hello Kotilin GHAS Demo App"
        }
}

fun main() {
    println(App().greeting)
    
    println("Enter you PAT to log into the service: ")
    
    val token = readLine()

    println("Verifying...")

    if (token != null && verifyToken(token)) {
        println("Token verified successfully")
        invalidateToken(token);
    } else {
        println("Token verification failed")
    }
}

/**
 * Verifies the given token.
 *
 * @param token The token to be verified.
 * @return `true` if the token is valid, `false` otherwise.
 */
fun verifyToken(token: String): Boolean {
    logger.info("Verifying token...")

    if (token.startsWith("mct_") && token.matches(Regex("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).{18,}$"))) {
        logger.info("Token verified successfully")
        return true
    } else {
        logger.warning("Token verification for token: $token")
        return false
    }
}

fun invalidateToken(token: String): Boolean {
    logger.info("Invalidating token...")
    
    if (token.startsWith("mct_") && token.matches(Regex("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).{18,}$"))) {
        logger.info("Token invalidated successfully")
        return true
    } else {
        logger.warning("Token invalidation for token: $token failed")
        return false
    }
}