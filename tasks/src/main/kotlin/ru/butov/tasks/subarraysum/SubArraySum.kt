package ru.butov.tasks.subarraysum

interface SubArraySum {
    fun getNumSubArrays(input: List<Int>, k: Int): Int
}

class SubArraySumGptSolutionImpl : SubArraySum {
    override fun getNumSubArrays(input: List<Int>, k: Int): Int {
        var count = 0
        var sum = 0
        val preSum = mutableMapOf<Int, Int>()
        preSum[0] = 1

        for (i in input.indices) {
            sum += input[i]
            if (preSum.containsKey(sum - k)) {
                println("sum - k = ${sum - k}")
                count += preSum[sum - k] ?: 0
            }
            preSum[sum] = preSum.getOrDefault(sum, 0) + 1
            println("i = $i, input = ${input[i]}.  sum = $sum")
            println(preSum)
        }
        return count
    }
}