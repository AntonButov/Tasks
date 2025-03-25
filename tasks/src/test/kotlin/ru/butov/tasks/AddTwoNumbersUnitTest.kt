package ru.butov.tasks

import org.junit.Test
import org.junit.Assert.*

class AddTwoNumbersUnitTest {

    private val addTwoNumbers
    get() = AddTwoNumbers()

    @Test
    fun caseFirst() {
        val listFirst = listOf(2,4,3)
        val listSecond = listOf(5,6,4)
        val expected = listOf(7,0,8)
        val test = addTwoNumbers.add(listFirst, listSecond)
        assertEquals(test, expected)
    }

    fun caseSecond() {
        val listFirst = listOf(9,9,9,9,9,9,9)
        val listSecond = listOf(9,9,9,9)
        val expected = listOf(8,9,9,9,0,0,0,1)
        val test = addTwoNumbers.add(listFirst, listSecond)
        assertEquals(test, expected)
    }


}