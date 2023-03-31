package ru.butov.tasks.path_in_matrics_whose_sum_Is_divisible_by_k

import org.junit.Test
import org.junit.Assert.*

class PathsInMatrixWhoseSumIsDivisibleByKTest {

    @Test
    fun caseZero() {
        val case = caseZero
        val pathsInMatrixWhoseSumIsDivisibleByK = PathsInMatrixWhoseSumIsDivisibleByK()
        val result = pathsInMatrixWhoseSumIsDivisibleByK
            .numberOfPaths(
                case.input.map {
                    it.toTypedArray().toIntArray()
                }.toTypedArray(), case.k
            )
        assertEquals(result, case.numberOfPath)
    }
    @Test
    fun caseFirst() {
       val case = caseFirst
        val pathsInMatrixWhoseSumIsDivisibleByK = PathsInMatrixWhoseSumIsDivisibleByK()
        val result = pathsInMatrixWhoseSumIsDivisibleByK
            .numberOfPaths(
                case.input.map {
                    it.toTypedArray().toIntArray()
                }.toTypedArray(), case.k
            )
        assertEquals(result, case.numberOfPath)
    }

    @Test
    fun caseSecond() {
       val case = caseSecond
        val pathsInMatrixWhoseSumIsDivisibleByK = PathsInMatrixWhoseSumIsDivisibleByK()
        val result = pathsInMatrixWhoseSumIsDivisibleByK
            .numberOfPaths(
                case.input.map {
                    it.toTypedArray().toIntArray()
                }.toTypedArray(), case.k
            )
        assertEquals(result, case.numberOfPath)
    }

    @Test
    fun caseThird() {
       val case = caseThird
        val pathsInMatrixWhoseSumIsDivisibleByK = PathsInMatrixWhoseSumIsDivisibleByK()
        val result = pathsInMatrixWhoseSumIsDivisibleByK
            .numberOfPaths(
                case.input.map {
                    it.toTypedArray().toIntArray()
                }.toTypedArray(), case.k
            )
        assertEquals(result, case.numberOfPath)
    }
}