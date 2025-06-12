package ru.butov.tasks.anagrams

interface GroupAnagrams {
    fun group(input: List<String>): List<List<String>>
}

class GroupAnagramsImpl : GroupAnagrams {

    override fun group(input: List<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()
        input.forEach { string ->
           val sortedString = string.toList().sorted().joinToString("")
           map[sortedString]?.add(string) ?: map.put(sortedString, mutableListOf(string))
        }
        return map.values.toList()
    }
}