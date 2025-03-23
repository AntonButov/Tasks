package ru.butov.tasks

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.butov.tasks.longestsubstring.LongestSubstring
import ru.butov.tasks.longestsubstring.LongestSubstringSecond
import ru.butov.tasks.longestsubstring.LongestSubstringThird

class LongestSubstringUnitTest {

    private val longestSubstring
    get() = LongestSubstring()

    private val longestSubstringSecond
        get() = LongestSubstringSecond()

    private val longestSubstringThird
    get() = LongestSubstringThird()

    @Test
    fun caseFirst() {
        val s = "abcabcbb"
        val excepted = 3
        assertEquals(excepted, longestSubstring.getCount(s))
        assertEquals(excepted, longestSubstringSecond.getCount(s))
        assertEquals(excepted, longestSubstringThird.getCount(s))
    }

    @Test
    fun caseSecond() {
        val s = "bbbbb"
        val excepted = 1
        assertEquals(excepted, longestSubstring.getCount(s))
        assertEquals(excepted, longestSubstringSecond.getCount(s))
    }

    @Test
    fun caseThird() {
        val s = "pwwkew"
        val excepted = 3
        assertEquals(excepted, longestSubstring.getCount(s))
        assertEquals(excepted, longestSubstringSecond.getCount(s))
    }
}