package ru.butov.tasks.dublicates

import junit.framework.TestCase.assertEquals
import org.junit.Assert.assertArrayEquals
import kotlin.test.Test

class RemoveInPlaceTest {

    private val removeDuplicates = RemoveInPlaceImpl()

    @Test
    fun `should remove 3`() {
        val input = intArrayOf(3, 2, 2, 3)
        val result = removeDuplicates.removeDuplicates(input, 3)

        assertEquals(2, result[0])
        assertEquals(2, result[1])
    }

    @Test
    fun `should remove 2`() {
        val input = intArrayOf(0,1,2,2,3,0,4,2)
        val expected = intArrayOf(0,1,4,0,3,-1,1-1,-1)
        val result = removeDuplicates.removeDuplicates(input, 2)

        assertArrayEquals(expected, result)
    }

}