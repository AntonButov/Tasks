package ru.butov.tasks.indexof

import kotlin.test.Test
import kotlin.test.assertEquals

class IndexOfTest {
    private val indexOf: IndexOf = IndexOfImpl()
    private val indexOfCache = IndexOfCacheImpl()

    @Test
    fun needleFoundInMiddle() {
        // haystack = "hello", needle = "ll"
        // → "ll" начинается с индекса 2
        assertEquals(2, indexOf.getIndex("hello", "ll"))
        assertEquals(2, indexOfCache.getIndex("hello", "ll"))
    }

    @Test
    fun needleAtStart() {
        // haystack = "hello", needle = "he"
        // → "he" начинается с индекса 0
        assertEquals(0, indexOf.getIndex("hello", "he"))
        assertEquals(0, indexOfCache.getIndex("hello", "he"))
    }

    @Test
    fun needleAtEnd() {
        // haystack = "abc", needle = "c"
        // → "c" начинается с индекса 2
        assertEquals(2, indexOf.getIndex("abc", "c"))
        assertEquals(2, indexOfCache.getIndex("abc", "c"))
    }

    @Test
    fun needleNotFound() {
        // haystack = "abc", needle = "d"
        // → нет вхождения → -1
        assertEquals(-1, indexOf.getIndex("abc", "d"))
        assertEquals(-1, indexOfCache.getIndex("abc", "d"))
    }

    @Test
    fun emptyNeedle() {
        // haystack = "abc", needle = ""
        // → вернуть 0 по условию
        assertEquals(0, indexOf.getIndex("abc", ""))
        assertEquals(0, indexOfCache.getIndex("abc", ""))
    }

    @Test
    fun bothEmpty() {
        // haystack = "", needle = ""
        // → вернуть 0
        assertEquals(0, indexOf.getIndex("", ""))
        assertEquals(0, indexOfCache.getIndex("", ""))
    }

    @Test
    fun needleLongerThanHaystack() {
        // haystack = "a", needle = "abc"
        // → не может быть вхождения → -1
        assertEquals(-1, indexOf.getIndex("a", "abc"))
        assertEquals(-1, indexOfCache.getIndex("a", "abc"))
    }

    @Test
    fun fullMatch() {
        // haystack = "abc", needle = "abc"
        // → полное совпадение → индекс 0
        assertEquals(0, indexOf.getIndex("abc", "abc"))
        assertEquals(0, indexOfCache.getIndex("abc", "abc"))
    }

    @Test
    fun repeatedPattern() {
        // haystack = "aaaaa", needle = "bba"
        // → не встречается → -1
        assertEquals(-1, indexOf.getIndex("aaaaa", "bba"))
        assertEquals(-1, indexOfCache.getIndex("aaaaa", "bba"))
    }

    @Test
    fun longestMatch() {
        // haystack = "aaaaaaaaaaaaaaaaab", needle = "aaaaaaab"
        // → полное совпадение → индекс
        assertEquals(10, indexOf.getIndex("aaaaaaaaaaaaaaaaab", "aaaaaaab"))
        assertEquals(10, indexOfCache.getIndex("aaaaaaaaaaaaaaaaab", "aaaaaaab"))

    }

}