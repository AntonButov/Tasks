package ru.butov.tasks.longestsubstring

import kotlin.math.max

class LongestSubstringThird {

    fun getCount(s: String): Int {
        var firstClearIndex = 0
        var result = 0
        val storage = mutableMapOf<Char, Int>()
        s.forEachIndexed { index, char ->
            val storedCharIndeх = storage[char]
            storedCharIndeх?.let {
                firstClearIndex = max(firstClearIndex, storedCharIndeх)
            }
            storage[char] = index
            val lengthSubstring = index - firstClearIndex
            result = maxOf(result, lengthSubstring)
        }
        return result
    }
}