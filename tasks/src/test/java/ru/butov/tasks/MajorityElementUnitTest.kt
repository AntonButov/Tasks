package com.example.tasks2

import org.junit.Test

import org.junit.Assert.*

class MajorityElementUnitTest {

    private val majorityElement
    get() = MajorityElement()

    @Test
    fun testFirst() {
        val source = listOf(3,2,3)
        val excepted = listOf(3)
        assertEquals(excepted, majorityElement.getMajor(source))
    }

    @Test
    fun testSecond() {
        val source = listOf(1,2)
        val excepted = listOf(1,2)
        assertEquals(excepted, majorityElement.getMajor(source))
    }

}