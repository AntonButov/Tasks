package ru.butov.tasks.prioretyqueue

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import ru.butov.tasks.PriorityQueue
import ru.butov.tasks.PriorityQueueImpl
import kotlin.test.Test

class PriorityQueueTest {

    private val priorityQueue: PriorityQueue
        get() = PriorityQueueImpl()

    @Test
    fun `should return all elements that appear more than once`() {
        val result = priorityQueue.getResult(listOf(1, 2, 2, 3, 4, 4, 4))
        assertEquals(setOf(2, 4), result.toSet())
    }

    @Test
    fun `should return empty list when all elements are unique`() {
        val result = priorityQueue.getResult(listOf(1, 2, 3, 4, 5))
        assertTrue(result.isEmpty())
    }

    @Test
    fun `should handle empty input list`() {
        val result = priorityQueue.getResult(emptyList())
        assertTrue(result.isEmpty())
    }

    @Test
    fun `should return element if it appears exactly twice`() {
        val result = priorityQueue.getResult(listOf(10, 10))
        assertEquals(listOf(10), result)
    }

    @Test
    fun `should work with negative numbers`() {
        val result = priorityQueue.getResult(listOf(-1, -2, -3, -1, -2))
        assertEquals(setOf(-1, -2), result.toSet())
    }

    @Test
    fun `should return each duplicate only once`() {
        val result = priorityQueue.getResult(listOf(5, 5, 5, 5))
        assertEquals(listOf(5), result)
    }
}