package ru.butov.tasks

interface TwoSum {
    fun twoSum(nums: List<Int>, target: Int): List<Int>
}

class TwoSumImpl : TwoSum {
    override fun twoSum(nums: List<Int>, target: Int): List<Int> {
        val map = hashMapOf<Int, Int>()
        nums.forEachIndexed { index, value ->
            val complement = target - value
            map[complement]?.let { return listOf(it, index) }
            map[value] = index
        }
        throw IllegalArgumentException("No two sum solution")
    }
}