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

}


