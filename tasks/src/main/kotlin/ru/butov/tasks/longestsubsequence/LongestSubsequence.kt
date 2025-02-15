package ru.butov.tasks.longestsubsequence

class LongestSubsequence {

    fun getCount(nums: List<Int>): Int {
        val sortedSet = mutableListOf(nums[0])
        (1..<nums.size).forEach {
            val num = nums[it]
            val index = sortedSet.binarySearch(num)
            val isFind = index > 0
            if (num > sortedSet[sortedSet.size - 1]) {
                sortedSet.add(num)
                return@forEach
            }
            val newIndex = if (isFind) index else - index - 1
            sortedSet[newIndex] = num
            println("sortedSet = $sortedSet")
        }
        return sortedSet.size
    }
}