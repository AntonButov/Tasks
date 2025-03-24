package ru.butov.tasks.longestsubstring

import java.util.HashSet

class LongestSubstringChatGpt {

    fun getCount(s: String): Int {
        var i = 0
        var j = 0
        var max = 0
        val set = HashSet<Char>()

        while (j < s.length) {
            if (set.contains(s[j])) {
                set.remove(s[i])
                i++
            } else {
                set.add(s[j])
                j++
                max = Math.max(max, set.size)
            }
        }

        return max
    }
}