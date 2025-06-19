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

class LastWordLengthGptImpl : LastWordLength {
    override fun length(s: String): Int {
        var i = s.length - 1
        var length = 0

        // Пропускаем пробелы справа
        while (i >= 0 && s[i] == ' ') {
            i--
        }

        // Считаем длину последнего слова
        while (i >= 0 && s[i] != ' ') {
            length++
            i--
        }

        return length
    }
}