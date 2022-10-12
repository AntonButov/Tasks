package ru.butov.tasks

class LongestCommonPrefix {

    fun getLongest(source: List<String>): String {
        val minLenth = source.min().count()
        val firstWord = source.minBy { it.length }
        return firstWord.mapIndexed { index, _ ->

    }

      private fun List<String>.prefixAll(prefix: String): Boolean  =
          all {
              it.substring(prefix.indices) == prefix
          }






        source.mapIndexed { index, _ ->
            source.substring(index until source.count())
        }
            .map { it.toLists() }
            .flatten()
            .filter { isPalindromic(it) }
            .maxBy { it.length }
    }

    private fun isPalindromic(str: String): Boolean =
        str == str.reversed()

    private fun String.toLists(): List<String> =
        mapIndexed { index, _ ->
            substring(0..index)
        }
}


