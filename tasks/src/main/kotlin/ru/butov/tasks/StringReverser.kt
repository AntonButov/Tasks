package ru.butov.tasks

interface StringReverser {
    fun reverseString(input: String): String
}

class StringReverserImpl : StringReverser {
    override fun reverseString(input: String): String {
        return buildString {
        (input.length - 1 downTo 0).forEach {
                append(input[it])
            }
        }
    }
}