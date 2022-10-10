package ru.butov.tasks

import org.junit.Assert.assertEquals
import org.junit.Test

class RegularExpressionMatchingUnitTest {

    private val regularExpressionMatching
    get() = RegularExpressionMatching()

    @Test
    fun caseFirst() {
        val s = "aa"
        val p = "a"
        val excepted = false
        assertEquals(excepted, regularExpressionMatching.isMatch(s, p))
    }

    @Test
    fun caseSecond() {
        val s = "aa"
        val p = "a*"
        val excepted = true
        assertEquals(excepted, regularExpressionMatching.isMatch(s, p))
    }

    @Test
    fun caseThird() {
        val s = "ab"
        val p = ".*"
        val excepted = true
        assertEquals(excepted, regularExpressionMatching.isMatch(s, p))
    }
}