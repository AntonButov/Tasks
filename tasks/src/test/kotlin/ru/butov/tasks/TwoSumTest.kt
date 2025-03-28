package ru.butov.tasks

import org.junit.Assert.assertEquals
import org.junit.Test

class TwoSumTest {

    val twoSum: TwoSum
    get() = TwoSumImpl()

    @Test
    fun `two sum basic test cases`() {
        assertEquals(listOf(0, 1), twoSum.twoSum(listOf(2, 7, 11, 15), 9))
        assertEquals(listOf(1, 2), twoSum.twoSum(listOf(3, 2, 4), 6))
        assertEquals(listOf(0, 1), twoSum.twoSum(listOf(3, 3), 6))
    }
}