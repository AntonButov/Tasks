package ru.butov.tasks

import java.lang.Math.pow
import java.util.LinkedList
import kotlin.math.max

class AddTwoNumbers {

    fun add(listFirst: List<Int>, listSecond: List<Int>): List<Int> {
        var index = 0
        val result = LinkedList<Int>()
        var isOver = false
        while (index < max(listFirst.size, listSecond.size)) {
            val indexFirst = listFirst.size - 1 - index
            val indexSecond = listSecond.size - 1 - index
            val firstNum = if (indexFirst >= 0) listFirst[indexFirst] else 0
            val secondNum = if (indexSecond >= 0) listSecond[indexSecond] else 0
            var resNum = firstNum + secondNum
            if (isOver) resNum++
            if (resNum >= 10) {
                isOver = true
                resNum %= 10
            } else isOver = false
            result.addLast(resNum)
            index ++
        }
        return result
    }
}