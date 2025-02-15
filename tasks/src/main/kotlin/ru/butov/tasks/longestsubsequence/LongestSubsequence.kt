package ru.butov.tasks.longestsubsequence

class LongestSubsequence {

    fun getCount(nums: List<Int>): Int {
        var sortedSet = mutableListOf(nums[0])
        (1..<nums.size).forEach {
            val num = nums[it]
            val index = sortedSet.binarySearch(num)
            val isFind = index > 0
            val newIndex = if (isFind) index else -index - 1
            sortedSet.add(newIndex, num)
            val isHalf = newIndex + 1 >= sortedSet.size / 2
            if (isHalf) {
                sortedSet = sortedSet.subList(0, newIndex + 1)
            }
            println("sortedSet = $sortedSet")
        }
        return sortedSet.size
    }
}