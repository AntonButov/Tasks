package ru.butov.tasks.path_in_matrics_whose_sum_Is_divisible_by_k

import org.junit.Assert.*
import org.junit.Test

class PathsInMatrixWhoseSumIsDivisibleByKKotlinTest {

    @Test
    fun numberOfPathTestZero() {
        val case = caseZero
        val pathsInMatrixWhoseSumIsDivisibleByKKotlin = PathInMatrixWhoseSumIsDivisibleByKKotlin()
        val numberOfPath = pathsInMatrixWhoseSumIsDivisibleByKKotlin.numberOfPaths(case.input,case.k)
        assertEquals(case.numberOfPath, numberOfPath)
    }

    @Test
    fun numberOfPathTestFirst() {
        val case = caseFirst
        val pathsInMatrixWhoseSumIsDivisibleByKKotlin = PathInMatrixWhoseSumIsDivisibleByKKotlin()
        val numberOfPath = pathsInMatrixWhoseSumIsDivisibleByKKotlin.numberOfPaths(case.input,case.k)
        assertEquals(case.numberOfPath, numberOfPath)
    }

    @Test
    fun numberOfPathTestSecond() {
       // val case = caseSecond //todo
       // val pathsInMatrixWhoseSumIsDivisibleByKKotlin = PathInMatrixWhoseSumIsDivisibleByKKotlin()
       // val numberOfPath = pathsInMatrixWhoseSumIsDivisibleByKKotlin.numberOfPaths(case.input,case.k)
      //  assertEquals(case.numberOfPath, numberOfPath)
    }

    @Test
    fun numberOfPathTestThird() {
      //  val case = caseThird //todo
     //   val pathsInMatrixWhoseSumIsDivisibleByKKotlin = PathInMatrixWhoseSumIsDivisibleByKKotlin()
      //  val numberOfPath = pathsInMatrixWhoseSumIsDivisibleByKKotlin.numberOfPaths(case.input,case.k)
     //   assertEquals(case.numberOfPath, numberOfPath)
    }

    @Test
    fun cacheSquashTest() {
        val cache = listOf(0, 1, 1)
        val expected = listOf(1, 2)
        val newList = cache.squash()
        assertEquals(expected, newList)
    }

    @Test
    fun addElement() {
        val k = 3
        val element = 1
        val cache = listOf(0, 1, 1, 2)
        val expected = listOf(1, 2, 2, 0)
        val newList = cache.addElement(element, k)
        assertEquals(expected, newList)
    }

    @Test
    fun addElementSecond() {
        val k = 3
        val element = 1
        val cache = listOf(0)
        val expected = listOf(1)
        val newList = cache.addElement(element, k)
        assertEquals(expected, newList)
    }

    @Test
    fun groupByK() {
        val cache = listOf(0, 0, 1, 1, 2)
        val expected = listOf(2, 2, 1)
        val newList = cache.groupByK(3)
        assertEquals(expected, newList)
    }

    @Test
    fun addCaches() {
        val cacheFirst = listOf(1, 1, 1)
        val cacheSecond = listOf(0, 1, 2)
        val expected = listOf(1, 2, 3)
        val newList = cacheFirst.addCaches(cacheSecond)
        assertEquals(expected, newList)
    }
}