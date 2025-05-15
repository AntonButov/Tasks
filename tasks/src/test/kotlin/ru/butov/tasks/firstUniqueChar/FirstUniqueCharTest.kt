package ru.butov.tasks.firstUniqueChar

import kotlin.test.Test
import kotlin.test.assertEquals

class FirstUniqueCharTest {

    private val solver = FirstUniqueCharImpl() // твоя реализация

    @Test
    fun singleUniqueAtStart() {
        // "leetcode" → 'l' уникальный, индекс 0
        assertEquals(0, solver.firstUniqueChar("leetcode"))
    }

    @Test
    fun singleUniqueInMiddle() {
        // "loveleetcode" → 'v' уникальный, индекс 2
        assertEquals(2, solver.firstUniqueChar("loveleetcode"))
    }

    @Test
    fun allDuplicates() {
        // "aabbcc" → все дублируются → -1
        assertEquals(-1, solver.firstUniqueChar("aabbcc"))
    }

    @Test
    fun uniqueAtEnd() {
        // "aabbc" → 'c' уникальный, индекс 4
        assertEquals(4, solver.firstUniqueChar("aabbc"))
    }

    @Test
    fun uniqueSingleChar() {
        // "z" → одна буква, уникальна → индекс 0
        assertEquals(0, solver.firstUniqueChar("z"))
    }

    @Test
    fun emptyString() {
        // "" → -1
        assertEquals(-1, solver.firstUniqueChar(""))
    }

    @Test
    fun firstAndLastUnique() {
        // "abcab" → 'c' уникальный, индекс 2
        assertEquals(2, solver.firstUniqueChar("abcab"))
    }
}