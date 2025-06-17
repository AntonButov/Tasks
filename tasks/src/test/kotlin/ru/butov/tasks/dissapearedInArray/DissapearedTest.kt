package ru.butov.tasks.dissapearedInArray

import ru.butov.tasks.disappearedInArray.Disappeared
import ru.butov.tasks.disappearedInArray.DisappearedImpl
import kotlin.test.Test
import kotlin.test.assertEquals

class DissapearedTest {
    private val disapeared: Disappeared
        get() = DisappearedImpl()

    @Test
    fun example1() {
        val input = listOf(4, 3, 2, 7, 8, 2, 3, 1)
        val expected = listOf(5, 6)
        assertEquals(expected.sorted(), disapeared.getDisappeared(input))
    }

    @Test
    fun example2() {
        val input = listOf(1, 1)
        val expected = listOf(2)
        assertEquals(expected, disapeared.getDisappeared(input))
    }

    @Test
    fun noMissingNumbers() {
        val input = listOf(1, 2, 3, 4, 5)
        val expected = emptyList<Int>()
        assertEquals(expected, disapeared.getDisappeared(input))
    }

    @Test
    fun allMissingExceptOne() {
        val input = List(10) { 1 } // все 1, остальные отсутствуют
        val expected = (2..10).toList()
        assertEquals(expected, disapeared.getDisappeared(input))
    }

    @Test
    fun emptyArray() {
        val input = listOf<Int>()
        val expected = emptyList<Int>()
        assertEquals(expected, disapeared.getDisappeared(input))
    }

    @Test
    fun fullReverse() {
        val input = listOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
        val expected = emptyList<Int>()
        assertEquals(expected, disapeared.getDisappeared(input))
    }

    @Test
    fun repeatedSequence() {
        val input = listOf(1, 2, 2, 2, 2, 2, 2, 2)
        val expected = listOf(3, 4, 5, 6, 7, 8)
        assertEquals(expected, disapeared.getDisappeared(input))
    }
}
