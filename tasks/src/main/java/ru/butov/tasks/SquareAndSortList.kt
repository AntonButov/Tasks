package ru.butov.tasks

import java.util.ArrayList
import java.util.LinkedList
import kotlin.math.abs

class SquareAndSortList {

    companion object {
        fun List<Int>.squareAndSort(): List<Int> {
            var startIndex = 0
            var endIndex = size - 1
            val result = ArrayList(this)
            while (startIndex <= endIndex) {
                val sqrtStart = get(startIndex) * get(startIndex)
                val sqrtEnd = get(endIndex) * get(endIndex)
                if (sqrtStart > sqrtEnd) {
                    result[endIndex - startIndex] = sqrtStart
                    startIndex++
                } else {
                    result[endIndex - startIndex] = sqrtEnd
                    endIndex--
                }
            }
            return result
        }

        fun List<Int>.squareAndSortWithDeque(): List<Int> {
            val deque = LinkedList<Int>()
            val result = listOf<Int>().toMutableList()
            for (element in this) {
                if (element < 0) {
                    deque.addFirst(abs(element))
                    continue
                }
                val dequeNew = LinkedList(deque)
                dequeNew.forEach {
                    if (it < element) {
                        deque.remove(it)
                        result.add(it * it)
                    }
                }
                result.add(element * element)
            }
            return result
        }

    }
}