package ru.butov.tasks

import java.util.LinkedList

class MergeTwoList(private val list1: LinkedList<Int>, private val list2: LinkedList<Int>) {
         val result = LinkedList<Int>()
    fun merge(): LinkedList<Int> {
        while (list1.isEmpty().not() || list2.isEmpty().not()) {
            val listCandidate1 = list1.peekFirst() ?: Int.MAX_VALUE
            val listCandidate2 = list2.peekFirst() ?: Int.MAX_VALUE
            if (listCandidate1 < listCandidate2) {
                result.add(list1.removeFirst())
            } else {
                result.add(list2.removeFirst())
            }
        }
        return result
    }
}