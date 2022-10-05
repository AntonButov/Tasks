package ru.butov.tasks

class LongestPalindromic {

    fun getLongest(source: String): String =
        source.mapIndexed { index, _ ->
            source.substring(index until source.count())
        }
            .map { it.toLists() }
            .flatten()
            .filter { isPalindromic(it) }
            .maxBy { it.length }

    private fun isPalindromic(str: String): Boolean =
        str == str.reversed()

    private fun String.toLists(): List<String> =
        mapIndexed { index, _ ->
            substring(0..index)
        }
}


