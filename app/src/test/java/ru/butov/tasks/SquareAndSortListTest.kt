package ru.butov.tasks

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.butov.tasks.SquareAndSortList.Companion.squareAndSort
import ru.butov.tasks.SquareAndSortList.Companion.squareAndSortWithDeque

class SquareAndSortListTest {

    @Test
    fun firstCase() {
        val input = listOf(-4, -1, 0, 3,  10)
        val result = listOf(0 ,1 , 9, 16, 100)
        assertEquals(result, input.squareAndSort())
        assertEquals(result, input.squareAndSortWithDeque())
    }

    @Test
    fun secondCase() {
        val input = listOf(-7, -3,2,3, 11)
        val result = listOf(4, 9, 9,49,121)
        assertEquals(result, input.squareAndSort())
        assertEquals(result, input.squareAndSortWithDeque())
    }
}