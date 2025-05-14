package ru.butov.tasks.firstUniqueChar

interface FirstUniqueChar {

    fun firstUniqueChar(s: String): Int

}


class FirstUniqueCharImpl : FirstUniqueChar {
    override fun firstUniqueChar(s: String): Int {
        val map = LinkedHashMap<Char, Int>()
        s.forEachIndexed { index, char ->
            if (map.containsKey(char)) {
                map.remove(char)
            } else {
                map.put(char, index)
            }
        }
        if (map.isEmpty()) return -1
        return map.iterator().next().value
    }
}