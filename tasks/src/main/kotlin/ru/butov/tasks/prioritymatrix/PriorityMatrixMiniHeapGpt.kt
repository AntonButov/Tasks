package ru.butov.tasks.prioritymatrix

import java.util.PriorityQueue

interface PriorityMatrixMiniHeapGpt {
    fun getNumber(input: List<List<Int>>, k: Int): Int
}

class PriorityMatrixMiniHeapGptImpl : PriorityMatrixMiniHeapGpt {
    data class Element(val value: Int, val row: Int, val col: Int) : Comparable<Element> {
        override fun compareTo(other: Element): Int = value.compareTo(other.value)
    }

    override fun getNumber(input: List<List<Int>>, k: Int): Int {
        val n = input.size
        val minHeap = PriorityQueue<Element>()
        for (i in 0 until n) {
            minHeap.offer(Element(input[i][0], i, 0))
        }

        for (i in 0 until k - 1) {
            val element = minHeap.poll()
            if (element.col + 1 < n) {
                minHeap.offer(Element(input[element.row][element.col + 1], element.row, element.col + 1))
            }
            println("queue = $minHeap")
        }
        return minHeap.poll().value
    }
}