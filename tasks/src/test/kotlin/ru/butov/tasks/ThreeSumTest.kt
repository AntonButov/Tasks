package ru.butov.tasks

import org.junit.Test

import org.junit.Assert.*

class ThreeSumTest {

    private val threeSum: ThreeSum
        get() = ThreeSum()

    @Test
    fun first() {
        val input = listOf(-1, 0, 1, 2, -1, -4)
        assertTrue(threeSum.find(input).all { it.sum() == 0 })
        assertTrue(threeSum.find(input).all { it.count() == 3 })
    }
}