package com.example.tasks2

import org.junit.Test

import org.junit.Assert.*

class IntToRangesUnitTest {

    private val intToRanges
    get() = IntToRanges()

    private val intToRangesDeclorative
    get() = IntToRangesDeclorative()

    @Test
    fun testFirst() {
        val source = listOf(0,1,2,4,5,7)
        val excepted = listOf("0->2","4->5","7")
        assertEquals(excepted, intToRanges.summaryRanges(source))
        assertEquals(excepted, intToRangesDeclorative.summaryRanges(source))
    }

    @Test
    fun testSecond() {
        val source = listOf(0,2,3,4,6,8,9)
        val excepted = listOf("0","2->4","6","8->9")
        assertEquals(excepted, intToRanges.summaryRanges(source))
        assertEquals(excepted, intToRangesDeclorative.summaryRanges(source))
    }

}