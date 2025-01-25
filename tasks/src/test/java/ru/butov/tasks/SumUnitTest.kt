package ru.butov.tasks

import org.junit.Test
import org.junit.Assert.*

class SumUnitTest {

    @Test
    fun case() {
        val sum = Sum()
        val expected = arrayListOf(0, 4, 1, 3)
        val test = sum.twoSum(listOf(2, 1, 11, 8, 7), target = 9)
        assertEquals(test, expected)
    }
}