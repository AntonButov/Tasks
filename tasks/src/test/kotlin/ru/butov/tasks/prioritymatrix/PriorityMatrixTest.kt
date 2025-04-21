package ru.butov.tasks.prioritymatrix

import ru.butov.tasks.PriorityQueueImpl
import kotlin.test.Test
import kotlin.test.assertEquals

class PriorityMatrixTest {

    val priorityMatrixIntervals: PriorityMatrix
        get() = PriorityMatrixIntervals()
    val priorityMatrixMiniHeapGpt: PriorityMatrixMiniHeapGpt
        get() = PriorityMatrixMiniHeapGptImpl()

    @Test
    fun `simple 3x3 matrix, k=8`() {
        val matrix = listOf(
            listOf(1, 5, 9),
            listOf(10, 11, 13),
            listOf(12, 13, 15)
        )
        val result = priorityMatrixIntervals.getNumber(matrix, 8)
        assertEquals(13, result)
        val resultPriorityMatrixMiniHeapGpt = priorityMatrixMiniHeapGpt.getNumber(matrix, 8)
        assertEquals(13, resultPriorityMatrixMiniHeapGpt)
    }

    @Test
    fun `2x2 matrix with duplicate, k=2`() {
        val matrix = listOf(
            listOf(1, 2),
            listOf(1, 3)
        )
        val result = priorityMatrixIntervals.getNumber(matrix, 2)
        assertEquals(1, result)
        val resultPriorityMatrixMiniHeapGpt = priorityMatrixMiniHeapGpt.getNumber(matrix, 2)
        assertEquals(1, resultPriorityMatrixMiniHeapGpt)
    }

    @Test
    fun `2x2 matrix, k=3`() {
        val matrix = listOf(
            listOf(1, 2),
            listOf(3, 4)
        )
        val result = priorityMatrixIntervals.getNumber(matrix, 3)
        assertEquals(3, result)
        val resultPriorityMatrixMiniHeapGpt = priorityMatrixMiniHeapGpt.getNumber(matrix, 3)
        assertEquals(3, resultPriorityMatrixMiniHeapGpt)
    }

    @Test
    fun `matrix with one element, k=1`() {
        val matrix = listOf(
            listOf(7)
        )
        val result = priorityMatrixIntervals.getNumber(matrix, 1)
        assertEquals(7, result)
        val resultPriorityMatrixMiniHeapGpt = priorityMatrixMiniHeapGpt.getNumber(matrix, 1)
        assertEquals(7, resultPriorityMatrixMiniHeapGpt)
    }

    @Test
    fun `larger 4x4 matrix, k=10`() {
        val matrix = listOf(
            listOf(1, 3, 5, 7),
            listOf(2, 4, 6, 8),
            listOf(9, 10, 11, 12),
            listOf(13, 14, 15, 16)
        )
        val result = priorityMatrixIntervals.getNumber(matrix, 10)
        assertEquals(10, result)
        val resultPriorityMatrixMiniHeapGpt = priorityMatrixMiniHeapGpt.getNumber(matrix, 10)
        assertEquals(10, resultPriorityMatrixMiniHeapGpt)
    }

    @Test
    fun `larger 4x4 matrix, k=11`() {
        val matrix = listOf(
            listOf(1, 4, 5),
            listOf(2, 7, 8),
            listOf(3, 10,11),
        )
        val result = priorityMatrixIntervals.getNumber(matrix, 4)
        assertEquals(4, result)
        val resultPriorityMatrixMiniHeapGpt = priorityMatrixMiniHeapGpt.getNumber(matrix, 4)
        assertEquals(4, resultPriorityMatrixMiniHeapGpt)
    }

    @Test
    fun `matrix with big jump in one row, k=6`() {
        val matrix = listOf(
            listOf(1, 2, 3),
            listOf(4, 100, 101),
            listOf(5, 102, 103)
        )
        val result = priorityMatrixIntervals.getNumber(matrix, 6)
        // Порядок: 1,2,3,4,5,100,101,102,103 → 6-й это 100
        assertEquals(100, result)
        val resultPriorityMatrixMiniHeapGpt = priorityMatrixMiniHeapGpt.getNumber(matrix, 6)
        assertEquals(100, resultPriorityMatrixMiniHeapGpt)
    }
}