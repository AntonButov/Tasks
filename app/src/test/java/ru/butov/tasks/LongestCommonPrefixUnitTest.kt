package ru.butov.tasks

import org.junit.Test
import org.junit.Assert.*

class LongestCommonPrefixUnitTest {

    private val longestCommonPrefix
    get() = LongestCommonPrefix()

    @Test
    fun case() {
        val input = listOf("flower","flow","flight")
        val expected = "fl"
        assertEquals(expected, longestCommonPrefix.getLongest(input))
    }

    @Test
    fun caseSecond() {
        val input = listOf("dog","racecar","car")
        val expected = ""
        assertEquals(expected, longestCommonPrefix.getLongest(input))
    }

}