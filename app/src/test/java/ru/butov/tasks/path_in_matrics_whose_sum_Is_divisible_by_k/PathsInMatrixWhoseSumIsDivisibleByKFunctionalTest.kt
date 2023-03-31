package ru.butov.tasks.path_in_matrics_whose_sum_Is_divisible_by_k

import org.junit.Assert.*
import org.junit.Test

class PathsInMatrixWhoseSumIsDivisibleByKFunctionalTest {

    @Test
    fun numberOfPathTestZero() {
        val case = caseZero
        val numberOfPath =
            case.input.numberOfPaths(case.k)
        assertEquals(case.numberOfPath, numberOfPath)
    }

    @Test
    fun numberOfPathTestFirst() {
        val case = caseFirst
        val numberOfPath =
            case.input.numberOfPaths(case.k)
        assertEquals(case.numberOfPath, numberOfPath)
    }

    @Test
    fun numberOfPathTestSecond() {
        val case = caseSecond
        val numberOfPath =
            case.input.numberOfPaths(case.k)
        assertEquals(case.numberOfPath, numberOfPath)
    }

    @Test
    fun numberOfPathTestThird() {
        val case = caseThird
        val numberOfPath =
            case.input.numberOfPaths(case.k)
        assertEquals(case.numberOfPath, numberOfPath)
    }
}