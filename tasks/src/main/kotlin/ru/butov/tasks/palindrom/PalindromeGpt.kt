package ru.butov.tasks.palindrom

interface PalindromeGpt {
    fun getLongest(input: String): Int
}

class PalindromeGptImpl : PalindromeGpt {
    override fun getLongest(input: String): Int {
        if (input.isEmpty()) return 0

        var start = 0
        var end = 0

        for (i in input.indices) {
            val len1 = expandAroundCenter(input, i, i)
            val len2 = expandAroundCenter(input, i, i + 1)
            val len = Math.max(len1, len2)
            if (len > end - start) {
                start = i - (len - 1) / 2
                end = i + len / 2
            }
        }
        return end - start + 1
    }

    private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
        var L = left
        var R = right

        while (L >= 0 && R < s.length && s[L] == s[R]) {
            L--
            R++
        }
        return R - L - 1
    }
}