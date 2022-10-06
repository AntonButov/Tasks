package ru.butov.tasks

class StringToInteger {

    fun toInteger(source: String): Int =
        source.fold("") { acc, char ->
            acc.addIfInt(char)
        }.toInt()

    private fun String.addIfInt(char: Char): String =
        if (char == '-' || char.isInt())
            buildString {
                append(this@addIfInt)
                append(char.toString())
            }
        else
            this

    private fun Char.isInt(): Boolean =
        digitToIntOrNull()?.let { true } ?: false
}