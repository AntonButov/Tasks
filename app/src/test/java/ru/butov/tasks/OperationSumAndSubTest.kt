package ru.butov.tasks

import org.junit.Assert.assertEquals
import org.junit.Test

class OperationSumAndSubTest {

    @Test
    fun firstCase() {
        val input = listOf(9, 3, 7)
        val target = 13
        assertEquals(input.operate(0, 0, target), true)
    }

    @Test
    fun secondCase() {
        val input = listOf(5, 5, 3)
        val target = 13
        assertEquals(input.operate(0, 0, target), true)
    }
}