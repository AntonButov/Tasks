package ru.butov.tasks.palindrom

import java.util.*
import kotlin.math.max

class PalindromeImpl {

    fun getLongest(input: String): Int {
        if (input.isEmpty()) return 0

        var max = 1
        val palindrom = LinkedList<Char>()

        fun reset(char: Char) {
            max = max(max, palindrom.size)
            palindrom.clear()
            palindrom.add(char)
        }

        input.forEachIndexed { index, char ->
            if (index == 0) {
                palindrom.add(char)
                return@forEachIndexed
            }

            val backIndex = index - palindrom.size - 1
            val backChar = if (backIndex >= 0) input[backIndex] else null

            when {
                palindrom.size == 1 && palindrom.last == char -> {
                    palindrom.add(char)
                }
                palindrom.size == 2 && palindrom.first == char && palindrom.last == char -> {
                    palindrom.add(char)
                }
                backChar == char -> {
                    palindrom.addFirst(backChar)
                    palindrom.addLast(char)
                }
                else -> {
                    reset(char)
                    return@forEachIndexed
                }
            }

            max = max(max, palindrom.size)
        }

        return max
    }
}