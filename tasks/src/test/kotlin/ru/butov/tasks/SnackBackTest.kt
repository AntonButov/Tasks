package ru.butov.tasks

import org.junit.Assert
import org.junit.Test

class SnackBackTest {

    @Test
    fun firstCase() {
        val weight = listOf(3, 5, 10)
        val W = 10
        Assert.assertEquals(2, SnackBack().getCount(weight, W))
    }

    @Test
    fun secondCase() {
        val weight = listOf(4, 3, 2, 1)
        val W = 10
        Assert.assertEquals(4, SnackBack().getCount(weight, W))
    }

    @Test
    fun thirdCase() {
        val weight = listOf(5, 4, 3, 2, 1)
        val W = 10
        Assert.assertEquals(4, SnackBack().getCount(weight, W))
    }

    @Test
    fun thousCase() {
        val weight = listOf(1, 2, 3, 4, 5)
        val W = 10
        Assert.assertEquals(4, SnackBack().getCount(weight, W))
    }

}