package ru.butov.tasks.subarraysum

interface SubArraySum {
    fun getNumSubArrays(input: List<Int>, k: Int): Int
}

class SubArraySumImpl() : SubArraySum {
    override fun getNumSubArrays(input: List<Int>, k: Int): Int {
        if (input.isEmpty()) return 0
        var result = 0
        var firstIndex = 0
        var secondIndex = 0
        var currentSum = input[0]
        while (true) {
            when {
                currentSum > k -> {
                    currentSum -= input[firstIndex]
                    ++firstIndex
                }

                currentSum == k -> {
                    ++result
                    currentSum -= input[firstIndex]
                    ++firstIndex
                }

                currentSum < k -> {
                    ++secondIndex
                    if (secondIndex == input.size) return result
                    currentSum += input[secondIndex]
                }
            }

        }
    }
}