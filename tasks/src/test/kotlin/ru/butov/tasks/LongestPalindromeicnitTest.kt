package ru.butov.tasks

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.butov.tasks.palindrom.*

class LongestPalindromicTest {

    private val longestPalindromic
        get() = LongestPalindromic()
    private val palindrom
        get() = PalindromeImpl()
    private val palindromeMiddle
        get() = PalindromeMiddle()
    private val palindromeGpt: PalindromeGpt
        get() = PalindromeGptImpl()
    private val palindromeManaker: PalindromeManaker
    get() = PalindromeManakerImpl()

    @Test
    fun caseZero() {
        val s = "bab"
        val excepted = "bab"
        assertEquals(excepted, longestPalindromic.getLongest(s))
        assertEquals(3, palindrom.getLongest(s))
        assertEquals(3, palindromeMiddle.getLongest(s))
        assertEquals(3, palindromeGpt.getLongest(s))
        assertEquals(3, palindromeManaker.getLongest(s))

    }

    @Test
    fun caseZeroPlus() {
        val s = "cbabc"
        val excepted = "cbabc"
        assertEquals(excepted, longestPalindromic.getLongest(s))
        assertEquals(5, palindrom.getLongest(s))
        assertEquals(5, palindromeMiddle.getLongest(s))
        assertEquals(5, palindromeGpt.getLongest(s))
        assertEquals(5, palindromeManaker.getLongest(s))
    }

    @Test
    fun caseFirst() {
        val s = "babad"
        val excepted = "bab"
        assertEquals(excepted, longestPalindromic.getLongest(s))
        assertEquals(3, palindrom.getLongest(s))
        assertEquals(3, palindromeMiddle.getLongest(s))
        assertEquals(3, palindromeGpt.getLongest(s))
        assertEquals(3, palindromeManaker.getLongest(s))
    }

    @Test
    fun caseSecond() {
        val s = "bb"
        val excepted = "bb"
        assertEquals(excepted, longestPalindromic.getLongest(s))
        assertEquals(2, palindrom.getLongest(s))
        assertEquals(2, palindromeMiddle.getLongest(s))
        assertEquals(2, palindromeGpt.getLongest(s))
        assertEquals(2, palindromeManaker.getLongest(s))
    }

    @Test
    fun caseSecondPlus() {
        val s = "cbbd"
        val excepted = "bb"
        assertEquals(excepted, longestPalindromic.getLongest(s))
        assertEquals(2, palindrom.getLongest(s))
        assertEquals(2, palindromeMiddle.getLongest(s))
        assertEquals(2, palindromeGpt.getLongest(s))
        assertEquals(2, palindromeManaker.getLongest(s))
    }

    @Test
    fun caseSecondPlusPlus() {
        val s = "bbb"
        val excepted = "bbb"
        assertEquals(excepted, longestPalindromic.getLongest(s))
        assertEquals(3, palindrom.getLongest(s))
        assertEquals(3, palindromeMiddle.getLongest(s))
        assertEquals(3, palindromeGpt.getLongest(s))
        assertEquals(3, palindromeManaker.getLongest(s))
    }

    @Test
    fun caseThird() {
        val s = " abacdfgdcaba"
        val excepted = "aba"
        assertEquals(excepted, longestPalindromic.getLongest(s))
        assertEquals(3, palindrom.getLongest(s))
        assertEquals(3, palindromeMiddle.getLongest(s))
        assertEquals(3, palindromeGpt.getLongest(s))
        assertEquals(3, palindromeManaker.getLongest(s))
    }

    @Test
    fun caseFourth() {
        val s = "abba"
        val excepted = "abba"
        assertEquals(excepted, longestPalindromic.getLongest(s))
        assertEquals(4, palindrom.getLongest(s))
        assertEquals(4, palindromeMiddle.getLongest(s))
        assertEquals(4, palindromeGpt.getLongest(s))
        assertEquals(4, palindromeManaker.getLongest(s))
    }

    @Test
    fun caseFourthPlus() {
        val s = "abbba"
        val excepted = "abbba"
        assertEquals(excepted, longestPalindromic.getLongest(s))
        assertEquals(5, palindrom.getLongest(s))
        assertEquals(5, palindromeMiddle.getLongest(s))
        assertEquals(5, palindromeGpt.getLongest(s))
        assertEquals(5, palindromeManaker.getLongest(s))
    }

    //"racecar"
    @Test
    fun caseFive() {
        val s = "racecar"
        val excepted = "racecar"
        assertEquals(excepted, longestPalindromic.getLongest(s))
        assertEquals(7, palindrom.getLongest(s))
        assertEquals(7, palindromeMiddle.getLongest(s))
        assertEquals(7, palindromeGpt.getLongest(s))
        assertEquals(7, palindromeManaker.getLongest(s))
    }

    @Test
    fun caseSeven_palindromeInMiddle() {
        val s = "abcddcba123"
        val expected = "abcddcba"
        assertEquals(expected, longestPalindromic.getLongest(s))
        assertEquals(8, palindrom.getLongest(s))
        assertEquals(8, palindromeMiddle.getLongest(s))
        assertEquals(8, palindromeGpt.getLongest(s))
        assertEquals(8, palindromeManaker.getLongest(s))
    }

    @Test
    fun caseEght() {
        val s = "abacdfgdcabba"
        val expected = "abba"
        assertEquals(expected, longestPalindromic.getLongest(s))
        assertEquals(4, palindrom.getLongest(s))
        assertEquals(4, palindromeMiddle.getLongest(s))
        assertEquals(4, palindromeGpt.getLongest(s))
        assertEquals(4, palindromeManaker.getLongest(s))
    }

    @Test
    fun caseEight_evenLength() {
        val s = "aabbaa"
        val expected = "aabbaa"
        assertEquals(expected, longestPalindromic.getLongest(s))
        assertEquals(6, palindrom.getLongest(s))
        assertEquals(6, palindromeMiddle.getLongest(s))
        assertEquals(6, palindromeGpt.getLongest(s))
        assertEquals(6, palindromeManaker.getLongest(s))
    }

    @Test
    fun caseNine_singleChar() {
        val s = "a"
        val expected = "a"
        assertEquals(expected, longestPalindromic.getLongest(s))
        assertEquals(1, palindrom.getLongest(s))
        assertEquals(1, palindromeMiddle.getLongest(s))
        assertEquals(1, palindromeManaker.getLongest(s))
    }

    @Test
    fun caseTen_noPalindromes() {
        val s = "abcdef"
        val expected = "a" // или любой другой одиночный символ
        assertEquals(expected.length, longestPalindromic.getLongest(s).length)
        assertEquals(1, palindrom.getLongest(s))
        assertEquals(1, palindromeMiddle.getLongest(s))
        assertEquals(1, palindromeManaker.getLongest(s))
    }

    @Test
    fun findPalindromeFromFirst() {
        val input = "qaca"
        assertEquals(3, PalindromeMiddle.findPalindromeFrom(input, 2))
    }

    @Test
    fun findPalindromeFromSecond() {
        val input = "qaacaa"
        assertEquals(5, PalindromeMiddle.findPalindromeFrom(input, 3))
    }

    @Test
    fun findPalindromeFromThird() {
        val input = "qac"
        assertEquals(1, PalindromeMiddle.findPalindromeFrom(input, 2))
    }
}