package ru.butov.tasks

import org.junit.Assert.assertEquals
import org.junit.Test

class WaterContainerTest {

    private val waterContainer: WaterContainer = WaterContainerImp()

    @Test
    fun testExample1() {
        val input = listOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        val expected = 49
        val result = waterContainer.getMaxWater(input)
        assertEquals(expected, result)
    }

    @Test
    fun testExample2() {
        val input = listOf(1, 1)
        val expected = 1
        val result = waterContainer.getMaxWater(input)
        assertEquals(expected, result)
    }

    @Test
    fun testExample3() {
        val input = listOf(4, 3, 2, 1, 4)
        val expected = 16
        val result = waterContainer.getMaxWater(input)
        assertEquals(expected, result)
    }

    @Test
    fun testMinimumSizeArray() {
        val input = listOf(1, 2)
        val expected = 1
        val result = waterContainer.getMaxWater(input)
        assertEquals(expected, result)
    }

    @Test
    fun testAllEqualHeights() {
        val input = listOf(1, 2, 3, 4, 5)
        val expected = 4
        val result = waterContainer.getMaxWater(input)
        assertEquals(expected, result)
    }

    @Test
    fun testDecreasingHeights() {
        val input = listOf(5, 4, 3, 2, 1)
        val expected = 6
        val result = waterContainer.getMaxWater(input)
        assertEquals(expected, result)
    }

    @Test
    fun testDecreasingHeights1() {
        val input = listOf(5, 5, 5, 5, 5)
        val expected = 20
        val result = waterContainer.getMaxWater(input)
        assertEquals(expected, result)
    }

}