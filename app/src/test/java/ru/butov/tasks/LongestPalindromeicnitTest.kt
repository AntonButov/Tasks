package ru.butov.tasks

import org.junit.Assert.assertEquals
import org.junit.Test

class LongestPalindromicTest {

    private val longestPalindromic
    get() = LongestPalindromic()

    @Test
    fun caseFirst() {
        val s = "babad"
        val excepted = "bab"
        assertEquals(excepted, longestPalindromic.getLongest(s))
    }

    @Test
    fun caseSecond() {
        val s = "cbbd"
        val excepted = "bb"
        assertEquals(excepted, longestPalindromic.getLongest(s))
    }

}