package ru.butov.tasks

import org.junit.Assert.assertEquals
import org.junit.Test

class StringToIntegerUnitTest {

    private val stringToInteger
    get() = StringToInteger()

    @Test
    fun caseFirst() {
        val string = "42"
        val excepted = 42
        assertEquals(excepted, stringToInteger.toInteger(string))
    }

    @Test
    fun caseSecond() {
        val string = "   -42"
        val excepted = -42
        assertEquals(excepted, stringToInteger.toInteger(string))
    }

    @Test
    fun caseThird() {
        val string = "4193 with words"
        val excepted = 4193
        assertEquals(excepted, stringToInteger.toInteger(string))
    }
}