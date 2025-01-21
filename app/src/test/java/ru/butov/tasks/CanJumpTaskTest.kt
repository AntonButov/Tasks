package ru.butov.tasks

import junit.framework.TestCase.assertEquals
import org.junit.Test

class CanJumpTaskTest {

    @Test
    fun firstCase() {
        val input = listOf(2,3,1,1,4)
        val expected = true
        assertEquals(expected, CanJump().isCunJump(input))
    }

    @Test
    fun secondCase() {
        val input = listOf(3,2,1,0,4)
        val expected = false
        assertEquals(expected, CanJump().isCunJump(input))
    }
}