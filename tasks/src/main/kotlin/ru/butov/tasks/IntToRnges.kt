package com.example.tasks2

class IntToRanges {

    fun summaryRanges(nums: List<Int>): List<String?> {
        val result =  mutableListOf<String>()
        if (nums.size == 0) {
            return result
        }
        var i = 0
        while (i < nums.size) {
            if (i == nums.size - 1 || nums[i] != nums[i + 1] - 1) {
                result.add(nums[i].toString() + "")
                i++
                continue
            }
            val left = nums[i]
            var j = i + 1
            while (j < nums.size) {
                if (j == nums.size - 1 || nums[j] != nums[j + 1] - 1) {
                    break
                }
                j++
            }
            result.add(left.toString() + "->" + nums[j])
            i = j
            i++
        }
        return result
    }
}