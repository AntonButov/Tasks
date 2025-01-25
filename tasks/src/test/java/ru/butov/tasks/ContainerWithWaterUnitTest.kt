package ru.butov.tasks

import org.junit.Assert.assertEquals
import org.junit.Test

class ContainerWithWaterUnitTest {

    private val containerWithMostWater
        get() = ContainerWithMostWater()

    @Test
    fun caseFirst() {
        val list = listOf(1, 5, 4, 3)
        val excepted = 6
        assertEquals(excepted, containerWithMostWater.getMostWater(list))
    }

    @Test
    fun caseSecond() {
        val list = listOf(1, 5, 4, 3)
        val excepted = 6
        assertEquals(excepted, containerWithMostWater.getMostWater(list))
    }
}