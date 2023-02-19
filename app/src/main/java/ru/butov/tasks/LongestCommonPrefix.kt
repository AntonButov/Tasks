package ru.butov.tasks

class LongestCommonPrefix {

    fun getLongest(source: List<String>): String {
        val shortestWord = source.minBy { it.length }
        return shortestWord.asSequence().mapIndexed { index, _ ->
            source.map {
                it.substring(0, index )
            }
        }.filter { list ->
            list.all { it == list.first() }
        }
            .flatten()
            .maxBy { it.count() }
    }

    fun getLongestImperative(source: List<String>): String {
        val firstString = source.first()
        var result = ""
        firstString.indices.forEach { charIndex ->
            (1 until source.count()).forEach { listIndex ->
                if (charIndex > source[listIndex].length ||
                    firstString[charIndex] != source[listIndex][charIndex]) return result
            }
            result += firstString[charIndex]
        }
        return result
    }

}


