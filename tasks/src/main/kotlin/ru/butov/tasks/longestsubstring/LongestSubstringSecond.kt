package ru.butov.tasks.longestsubstring

class LongestSubstringSecond {

    fun getCount(source: String): Int =
        source.mapIndexed { index, _ ->
            source.substring(index until source.count())
        }
            .map { it.toLists() }
            .flatten()
            .filter { isIndividual(it) }
            .maxBy { it.length }
            .count()

    private fun isIndividual(string: String) =
        string.none { it in string.withOut(it) }

    private fun String.withOut(ch: Char): String =
        replaceFirst(ch.toString(), "")


    private fun String.toLists(): List<String> =
        mapIndexed { index, _ ->
            substring(0..index)
        }
}