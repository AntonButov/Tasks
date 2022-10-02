package ru.butov.tasks

import org.junit.Assert.assertEquals
import org.junit.Test

class LongestSubstringUnitTest {

    private val longestSubstring
    get() = LongestSubstring()

    @Test
    fun caseFirst() {
        val s = "abcabcbb"
        val excepted = 3
        assertEquals(excepted, longestSubstring.getCount(s))
    }

    @Test
    fun caseSecond() {
        val s = "bbbbb"
        val excepted = 1
        assertEquals(excepted, longestSubstring.getCount(s))
    }

    @Test
    fun caseThird() {
        val s = "pwwkew"
        val excepted = 3
        assertEquals(excepted, longestSubstring.getCount(s))
    }
}