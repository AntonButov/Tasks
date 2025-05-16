package ru.butov.tasks.indexof

import kotlin.test.Test
import kotlin.test.assertEquals

class IndexOfTest {
    private val indexOf: IndexOf = IndexOfImpl()

    @Test
    fun needleFoundInMiddle() {
        // haystack = "hello", needle = "ll"
        // → "ll" начинается с индекса 2
        assertEquals(2, indexOf.getIndex("hello", "ll"))
    }

    @Test
    fun needleAtStart() {
        // haystack = "hello", needle = "he"
        // → "he" начинается с индекса 0
        assertEquals(0, indexOf.getIndex("hello", "he"))
    }

    @Test
    fun needleAtEnd() {
        // haystack = "abc", needle = "c"
        // → "c" начинается с индекса 2
        assertEquals(2, indexOf.getIndex("abc", "c"))
    }

    @Test
    fun needleNotFound() {
        // haystack = "abc", needle = "d"
        // → нет вхождения → -1
        assertEquals(-1, indexOf.getIndex("abc", "d"))
    }

    @Test
    fun emptyNeedle() {
        // haystack = "abc", needle = ""
        // → вернуть 0 по условию
        assertEquals(0, indexOf.getIndex("abc", ""))
    }

    @Test
    fun bothEmpty() {
        // haystack = "", needle = ""
        // → вернуть 0
        assertEquals(0, indexOf.getIndex("", ""))
    }

    @Test
    fun needleLongerThanHaystack() {
        // haystack = "a", needle = "abc"
        // → не может быть вхождения → -1
        assertEquals(-1, indexOf.getIndex("a", "abc"))
    }

    @Test
    fun fullMatch() {
        // haystack = "abc", needle = "abc"
        // → полное совпадение → индекс 0
        assertEquals(0, indexOf.getIndex("abc", "abc"))
    }

    @Test
    fun repeatedPattern() {
        // haystack = "aaaaa", needle = "bba"
        // → не встречается → -1
        assertEquals(-1, indexOf.getIndex("aaaaa", "bba"))
    }

    @Test
    fun longestMatch() {
        // haystack = "aaaaaaaaaaaaaaaaab", needle = "aaaaaaab"
        // → полное совпадение → индекс
        assertEquals(10, indexOf.getIndex("aaaaaaaaaaaaaaaaab", "aaaaaaab"))
    }

}