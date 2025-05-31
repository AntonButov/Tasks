package ru.butov.tasks

import org.junit.Test
import org.junit.Assert.*
import ru.butov.tasks.longestCommonPrefix.LongestCommonPrefix

class LongestCommonPrefixUnitTest {

    private val longestCommonPrefix
    get() = LongestCommonPrefix()

    @Test
    fun case() {
        val input = listOf("flower","flow","flight")
        val expected = "fl"
        assertEquals(expected, longestCommonPrefix.getLongestImperative(input))
    }

    @Test
    fun caseSecond() {
        val input = listOf("dog","racecar","car")
        val expected = ""
        assertEquals(expected, longestCommonPrefix.getLongestImperative(input))
    }

    @Test
    fun caseImperative() {
        val input = listOf("flower","flow","flight")
        val expected = "fl"
        assertEquals(expected, longestCommonPrefix.getLongestImperative(input))
    }

    @Test
    fun caseSecondImperative() {
        val input = listOf("dog","racecar","car")
        val expected = ""
        assertEquals(expected, longestCommonPrefix.getLongestImperative(input))
    }

    @Test
    fun singleWord() {
        assertEquals("a", longestCommonPrefix.getLongestImperative(listOf("a")))
    }

    @Test
    fun emptyStringIncluded() {
        assertEquals("", longestCommonPrefix.getLongestImperative(listOf("", "abc")))
    }

    @Test
    fun allSameWord() {
        assertEquals("abc", longestCommonPrefix.getLongestImperative(listOf("abc", "abc", "abc")))
    }

    @Test
    fun prefixMatchesWholeWord() {
        assertEquals("a", longestCommonPrefix.getLongestImperative(listOf("a", "ab", "ac")))
    }

    @Test
    fun longCommonPrefix() {
        assertEquals("inters", longestCommonPrefix.getLongestImperative(listOf("interspecies", "interstellar", "interstate")))
    }

    @Test
    fun mixedLengthWords() {
        assertEquals("go", longestCommonPrefix.getLongestImperative(listOf("go", "gorilla", "gold")))
    }

    @Test
    fun allEmpty() {
        assertEquals("", longestCommonPrefix.getLongestImperative(listOf("", "", "")))
    }

}