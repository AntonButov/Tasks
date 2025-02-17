package ru.butov.tasks.longestsubsequence

import org.junit.Assert
import org.junit.Test

class LongestSubsequenceTest {

    @Test
    fun firstCase() {
        val nums = listOf(10,9,2,5,3,7,101,18)
     //   val result = LongestSubsequence().getCount(nums)
    //    Assert.assertEquals(4, result)
        val resultTree = LongestSubstringTree().lengthOfLIS(nums.toIntArray())
        Assert.assertEquals(4, resultTree)
    }

    @Test
    fun secondCase() {
        val nums = listOf(9,1,4,2,3,3,7)
        val result = LongestSubsequence().getCount(nums)
        Assert.assertEquals(4, result)
    }

    @Test
    fun thirdCase() {
        val nums = listOf(0,3,1,3,2,3)
        val result = LongestSubsequence().getCount(nums)
        Assert.assertEquals(4, result)
    }
}