package ru.butov.tasks.lastWordLength

interface LastWordLength {
    fun length(s: String): Int
}

class LastWordLengthImpl : LastWordLength {
    override fun length(s: String): Int {
        for (i in s.length - 1 downTo 0) {
            if (s[i] != ' ') {
                return getLengthFromWord(s.substring(0, i + 1))
            }
        }
        return 0
    }

    private fun getLengthFromWord(s: String): Int {
        var length = 0
        for (i in s.length - 1  downTo 0) {
            if (s[i] == ' ') {
                return length
            }
            length++
        }
        return length
    }
}