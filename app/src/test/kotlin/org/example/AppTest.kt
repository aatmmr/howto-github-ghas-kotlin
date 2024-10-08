/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class AppTest {
    @Test fun appHasAGreeting() {
        val classUnderTest = App()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }

    @Test
    fun testVerifyToken() {
        // Valid token
        val validToken = "mct_aB1@345678901234567"
        assertTrue(verifyToken(validToken), "Token should be verified successfully")

        // Invalid token (too short)
        val shortToken = "mct_aB1@345"
        assertFalse(verifyToken(shortToken), "Token should fail verification due to insufficient length")

        // Invalid token (missing special character)
        val noSpecialCharToken = "mct_aB1345678901234567"
        assertFalse(verifyToken(noSpecialCharToken), "Token should fail verification due to missing special character")

        // Invalid token (missing number)
        val noNumberToken = "mct_aB@cdefghijklmnopqr"
        assertFalse(verifyToken(noNumberToken), "Token should fail verification due to missing number")

        // Invalid token (missing prefix)
        val noPrefixToken = "aB1@345678901234567"
        assertFalse(verifyToken(noPrefixToken), "Token should fail verification due to missing 'mct_' prefix")
    }
}
