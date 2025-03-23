package ru.butov.tasks.longestsubstring

class LongestSubstring {

    fun getCount(source: String): Int =
        source.mapIndexed { index, _ ->
            val substring = source.substring(index until source.count())
            substring.fold("") { acc, char ->
                acc.addIfNot(char)
            }
                .replace(";", "")
                .count()
        }
            .max()

    private fun String.addIfNot(char: Char): String {
        if (isClose()) return this
        if (contains(char))
            return add(';')
        return add(char)
    }

    private fun String.add(char: Char): String =
        buildString {
            append(this@add)
            append(char)
        }

    private fun String.isClose(): Boolean =
        contains(';')
}