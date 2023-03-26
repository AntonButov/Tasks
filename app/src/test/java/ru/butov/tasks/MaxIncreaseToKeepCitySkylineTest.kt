package ru.butov.tasks

import org.junit.Test
import org.junit.Assert.*

class MaxIncreaseToKeepCitySkylineTest {


    @Test
    fun caseFirst() {
        val input = listOf(
            listOf(3, 0, 8, 4),
            listOf(2, 4, 5, 7),
            listOf(9, 2, 6, 3),
            listOf(0, 3, 1, 0)
        )
        val producer = MaxIncreaseToKeepCitySkyline()
        val expected = listOf(
            listOf(8, 4, 8, 7),
            listOf(7, 4, 7, 7),
            listOf(9, 4, 8, 7),
            listOf(3, 3, 3, 3)
        )
        val result = producer.increase(input)
        assertEquals(result, expected)
    }
}