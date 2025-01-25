package ru.butov.tasks

import java.lang.Math.pow

class AddTwoNumbers {

    fun add(listFirst: List<Int>, listSecond: List<Int>): Int =
        listFirst.toNumber() + listSecond.toNumber()

    private fun List<Int>.toNumber() =
        reduceIndexed { index, acc, element ->
            acc + element * pow(10.toDouble(),index.toDouble()).toInt()
        }
}