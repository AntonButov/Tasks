package ru.butov.tasks

import org.junit.Test
import org.junit.Assert.*

class SumUnitTest {

    @Test
    fun firstCase() {
        val sum = Sum()
        val firstCase = listOf(2, 1, 11, 8, 7)
        val expectedFirst = listOf(0, 4)
        val expectedSecond = listOf(1, 3)
        val test = sum.twoSum(firstCase, 9)
        assertTrue(test.containsAll(expectedFirst))
        assertTrue(test.containsAll(expectedSecond))
        val testN = sum.twoSumN(firstCase, 9)
        assertTrue(testN.containsAll(expectedFirst))
        assertTrue(testN.containsAll(expectedSecond))
    }

    @Test
    fun secondCase() {
        val sum = Sum()
        val firstCase = listOf(2, 7, 11, 15)
        val expectedFirst = listOf(0, 1)
        val test = sum.twoSum(firstCase, 9)
        assertTrue(test.containsAll(expectedFirst))
        val testN = sum.twoSumN(firstCase, 9)
        assertTrue(testN.containsAll(expectedFirst))
    }
}