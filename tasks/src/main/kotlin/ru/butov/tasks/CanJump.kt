package ru.butov.tasks

class CanJump {
    fun isJumpRecursive(nums: List<Int>): Boolean {
        if (nums[0] == 0) {
            return false
        }
        if (isFinalJump(nums)) {
            return true
        }
        val size: Int = nums.size
        if (size > 2) {
            val currentNums = nums.subList(nums[0], size)
            return isJumpRecursive(currentNums)
        }
        return false
    }

    private fun isFinalJump(nums: List<Int>): Boolean {
        return nums.size - nums[0] <= 1
    }
}