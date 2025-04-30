package ru.butov.tasks.subarraysum

import kotlin.test.Test
import kotlin.test.assertEquals

class SubArrayTaskTest {

       val subarraySum: SubArraySum
           get() = SubArraySumGptSolutionImpl()

        @Test
        fun basicCase() {
            assertEquals(2, subarraySum.getNumSubArrays(listOf(1,1,1), 2))
        }

        @Test
        fun negativeNumbers() {
            assertEquals(3, subarraySum.getNumSubArrays(listOf(1,-1,0), 0))
        }

        @Test
        fun noSolution() {
            assertEquals(0, subarraySum.getNumSubArrays(listOf(1,2,3), 7))
        }

        @Test
        fun oneLargeSubarray() {
            assertEquals(1, subarraySum.getNumSubArrays(listOf(1,2,3,4,5), 15))
        }

        @Test
        fun allZeros() {
            assertEquals(15, subarraySum.getNumSubArrays(listOf(0,0,0,0,0), 0))
        }

        @Test
        fun mixedPositiveAndNegative() {
            assertEquals(4, subarraySum.getNumSubArrays(listOf(3,4,7,2,-3,1,4,2), 7))
        }

       @Test
       fun fromOntoFor() {
            assertEquals(1, subarraySum.getNumSubArrays(listOf(1,2,3,4), 5))
       }
    }

