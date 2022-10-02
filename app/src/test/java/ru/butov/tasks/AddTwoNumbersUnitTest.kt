package ru.butov.tasks

import org.junit.Test
import org.junit.Assert.*

class AddTwoNumbersUnitTest {

    private val addTwoNumbers
    get() = AddTwoNumbers()

    @Test
    fun caseFirst() {
        val listFirst = listOf(3,4,2)
        val listSecond = listOf(4,6,5)
        val expected = 807
        val test = addTwoNumbers.add(listFirst, listSecond)
        assertEquals(test, expected)
    }


}