package ru.butov.tasks

import org.junit.Test
import kotlin.test.assertEquals

class MaxSubbArrayTest {

    @Test
    fun firstCase() {
        val input = listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4) // [4,-1,2,1] -> 6
        assertEquals(6, MaxSubbArray(input).getMaxSum())
    }

    @Test
    fun secondCase() {
        val input = listOf(1)
        assertEquals(1, MaxSubbArray(input).getMaxSum())
    }

    @Test
    fun thirdCase() {
        val input = listOf(5, 4, -1, 7, 8) // [5,4,-1,7,8] -> 23
        assertEquals(23, MaxSubbArray(input).getMaxSum())
    }

    @Test
    fun allNegative() {
        val input = listOf(-1, -2, -3, -4, -5)
        assertEquals(-1, MaxSubbArray(input).getMaxSum())
    }

    @Test
    fun containsZeroAndPositive() {
        val input = listOf(0, -1, 2)
        assertEquals(2, MaxSubbArray(input).getMaxSum())
    }
}