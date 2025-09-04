package ru.butov.tasks

import kotlin.math.max

class MaxSubbArray(val list: List<Int>) {

    fun getMaxSum(): Int {
        assert(list.isNotEmpty())
        var result = 0
        var max = Int.MIN_VALUE
        list.forEach {
            val newResult = result + it
            if (newResult > 0) {
                result = newResult
            } else {
                if (it > 0) {
                    result = it
                } else {
                    result = 0
                }
            }
            max = max(max, newResult)
        }
        return max
    }

}