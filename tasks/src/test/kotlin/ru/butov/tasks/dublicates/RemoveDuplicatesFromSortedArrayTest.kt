package ru.butov.tasks.dublicates

import org.junit.Test
import kotlin.test.assertEquals

class RemoveDuplicatesFromSortedArrayTest {

    private val removeDuplicates = RemoveDuplicatesFromSortedArray()

    @Test
    fun noDuplicates() {
        with(removeDuplicates) {
            val input = "12345"
            val expected = "12345"
            assertEquals(expected, input.removeDuplicates())
        }
    }

    @Test
    fun allDuplicates() {
        with(removeDuplicates) {
            val input = "2222"
            val expected = "2"
            assertEquals(expected, input.removeDuplicates())
        }
    }

    @Test
    fun mixedDuplicates() {
        with(removeDuplicates) {
            val input = "00111223344"
            val expected = "01234"
            assertEquals(expected, input.removeDuplicates())
        }
    }

    @Test
    fun singleElement() {
        with(removeDuplicates) {
            val input = "7"
            val expected = "7"
            assertEquals(expected, input.removeDuplicates())
        }
    }

    @Test
    fun emptyString() {
        with(removeDuplicates) {
            val input = ""
            val expected = ""
            assertEquals(expected, input.removeDuplicates())
        }
    }

    @Test
    fun twoDuplicates() {
        with(removeDuplicates) {
            val input = "11"
            val expected = "1"
            assertEquals(expected, input.removeDuplicates())
        }
    }
}