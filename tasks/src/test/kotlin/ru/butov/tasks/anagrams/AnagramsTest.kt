package ru.butov.tasks.anagrams

import kotlin.test.Test
import kotlin.test.assertEquals

class AnagramsTest {

        private val solver: GroupAnagrams = GroupAnagramsImpl() // ← твоя реализация

        private fun normalize(result: List<List<String>>): List<List<String>> {
            return result.map { it.sorted() }.sortedBy { it.firstOrNull() ?: "" }
        }

        @Test
        fun example1() {
            val input = listOf("eat", "tea", "tan", "ate", "nat", "bat")
            val expected = listOf(
                listOf("eat", "tea", "ate"),
                listOf("tan", "nat"),
                listOf("bat")
            )
            assertEquals(normalize(expected), normalize(solver.group(input)))
        }

        @Test
        fun oneEmptyString() {
            val input = listOf("")
            val expected = listOf(listOf(""))
            assertEquals(normalize(expected), normalize(solver.group(input)))
        }

        @Test
        fun singleLetter() {
            val input = listOf("a")
            val expected = listOf(listOf("a"))
            assertEquals(normalize(expected), normalize(solver.group(input)))
        }

        @Test
        fun allDifferentWords() {
            val input = listOf("abc", "def", "ghi")
            val expected = listOf(
                listOf("abc"),
                listOf("def"),
                listOf("ghi")
            )
            assertEquals(normalize(expected), normalize(solver.group(input)))
        }

        @Test
        fun allAnagrams() {
            val input = listOf("abc", "bca", "cab", "bac", "acb", "cba")
            val expected = listOf(
                listOf("abc", "bca", "cab", "bac", "acb", "cba")
            )
            assertEquals(normalize(expected), normalize(solver.group(input)))
        }

        @Test
        fun duplicatesInInput() {
            val input = listOf("aab", "aba", "aab", "baa")
            val expected = listOf(
                listOf("aab", "aba", "aab", "baa")
            )
            assertEquals(normalize(expected), normalize(solver.group(input)))
        }
}