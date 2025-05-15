package ru.butov.tasks

import kotlin.test.Test
import kotlin.test.assertEquals // Используем assertEquals из kotlin.test

class ReverseStringTest {

    private val reverser: StringReverser = StringReverserImpl() // Ваша реализация

    @Test
    fun basicCase() {
        val input = "hello"
        val expected = "olleh"
        val actual = reverser.reverseString(input)
        assertEquals(expected, actual)
    }

    @Test
    fun evenLength() {
        val input = "abcd"
        val expected = "dcba"
        val actual = reverser.reverseString(input)
        assertEquals(expected, actual)
    }

    @Test
    fun singleChar() {
        val input = "z"
        val expected = "z"
        val actual = reverser.reverseString(input)
        assertEquals(expected, actual)
    }

    @Test
    fun emptyStringTest() { // Переименовано для ясности
        val input = ""
        val expected = ""
        val actual = reverser.reverseString(input)
        assertEquals(expected, actual)
    }

    @Test
    fun palindrome() {
        val input = "madam"
        val expected = "madam"
        val actual = reverser.reverseString(input)
        assertEquals(expected, actual)
    }
}