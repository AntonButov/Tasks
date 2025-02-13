package ru.butov.tasks

import org.junit.Assert
import org.junit.Test
import ru.butov.tasks.longestsubsequence.LongestSubsequence

class LongestSubsequenceTest {

    @Test
    fun firstCase() {
        val nums = listOf(10,9,2,5,3,7,101,18)
        val result = LongestSubsequence().getCount(nums)
        Assert.assertEquals(4, result)
    }

    @Test
    fun secondCase() {
        val nums = listOf(9,1,4,2,3,3,7)
        val result = LongestSubsequence().getCount(nums)
        Assert.assertEquals(4, result)
    }
}