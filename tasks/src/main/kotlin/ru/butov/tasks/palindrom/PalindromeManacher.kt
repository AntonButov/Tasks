package ru.butov.tasks.palindrom

interface PalindromeManaker {

    fun getLongest(input: String): Int
}

class PalindromeManakerImpl : PalindromeManaker {
    override fun getLongest(input: String): Int {
        if (input.isEmpty()) return 0

        // Шаг 1: преобразуем строку — вставляем # между символами
        val processed = preprocess(input)

        val p = IntArray(processed.length).toMutableList() // Радиусы палиндромов
        var center = 0     // Текущий центр
        var right = 0      // Правая граница текущего палиндрома
        var maxLen = 0     // Максимальный радиус

        for (i in processed.indices) {
            val mirror = 2 * center - i

            // Используем отражение, если внутри правой границы
            if (i < right) {
                p[i] = minOf(right - i, p[mirror])
            }

            // Расширяем вокруг центра i
            while (
                i + p[i] + 1 < processed.length &&
                i - p[i] - 1 >= 0 &&
                processed[i + p[i] + 1] == processed[i - p[i] - 1]
            ) {
                p[i]++
            }

            // Обновляем центр и правую границу, если нужно
            if (i + p[i] > right) {
                center = i
                right = i + p[i]
            }

            // Обновляем максимум
            maxLen = maxOf(maxLen, p[i])
        }

        return maxLen
    }

    private fun preprocess(s: String): String {
        return buildString {
            append('#')
            for (c in s) {
                append(c)
                append('#')
            }
        }
    }
}