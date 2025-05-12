package ru.butov.tasks.subarray

interface Subarray {
    fun getNum(input: List<Int>, k: Int): Int

}
class SubbArrayImpl: Subarray {
    override fun getNum(input: List<Int>, k: Int): Int {
        var result = 0
        val sums = mutableMapOf<Int,Int>()
        var sum = 0
        input.forEachIndexed { index, num ->
            sum += num
            sums.putIfAbsent(sum, index + 1)
            if (sum == k) {
                result = maxOf(index + 1, result)
            }
            val oldSum = sum - k
            sums[oldSum]?.let {
                result = maxOf(result, sums[sum]!! - it)
            }
        }
        return result
    }
}

class SubbArrayOptImpl: Subarray {
    override fun getNum(input: List<Int>, k: Int): Int {
        var result = 0
        val sums = mutableMapOf<Int,Int>()
        sums[0] = -1
        var sum = 0
        input.forEachIndexed { index, num ->
            sum += num
            sums.putIfAbsent(sum, index)
            if (sums.containsKey(sum - k)) {
                val prevIndex = sums[sum - k]!!
                result = maxOf(result, index - prevIndex)
            }
        }
        return result
    }
}