package ru.butov.tasks.decodestring

import java.util.LinkedList

class DecodeString {

    fun decodeRecursive(input: String): String {
        val deque = LinkedList(input.toList())
        return decodeInternal(deque, 1)
    }

    private fun decodeInternal(deque: LinkedList<Char>, num: Int = 1): String {

        val result = StringBuilder()

        while (deque.isNotEmpty()) {
            val char = deque.removeFirst()
            if (char.isDigit()) {
                val newNum = char.digitToInt()
                result.append(decodeInternal(deque, newNum))
                continue
            }
            if (char == '[') {
                continue
            }
            if (char == ']') {
                return buildString {
                    repeat(num) {
                        append(result.toString())
                    }
                }
            }
            result.append(char)
        }
        return result.toString()
    }

}