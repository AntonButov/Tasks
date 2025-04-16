package ru.butov.tasks

import java.util.Comparator

interface PriorityQueue {
    fun getResult(input: List<Int>): List<Int>
}

class PriorityQueueImpl: PriorityQueue {
    private val priorityQueue = java.util.PriorityQueue(
        Comparator<Num> { o1, o2 ->
                o2.counts - o1.counts
        }
    )
    private val map = mutableMapOf<Int,Int>()

    override fun getResult(input: List<Int>): List<Int> {
        input.forEach { number ->
            map.getOrDefault(number, 0).let {
                priorityQueue.remove(Num(number, it))
                map[number] = it + 1
                priorityQueue.add(Num(number, it + 1))
            }
        }
        return priorityQueue.filter { it.counts > 1 }.map { it.key }.toList()
    }
}

data class Num(val key: Int, val counts: Int)




