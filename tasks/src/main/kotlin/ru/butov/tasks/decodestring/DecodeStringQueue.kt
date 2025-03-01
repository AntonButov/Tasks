package ru.butov.tasks.decodestring

class DecodeStringQueue {

    fun decode(input: String): String {

        val things = ArrayDeque<Thing>()
        things.add(Thing())

        input.forEach { char: Char ->
            if (char.isDigit()) {
                things.add(
                    Thing(
                        number = char.digitToInt()
                    )
                )
                return@forEach
            }
            if (char == '[') {
                return@forEach
            }
            val currentThin = things.last()
            if (char == ']') {
                val currentString = currentThin.toString()
                things.removeLast()
                val currentThings = things.last()
                currentThings.chars.append(currentString)
                return@forEach
            }
            // char
            currentThin.chars.append(char)
        }
        return things.removeLast().toString()
    }

    class Thing(
        val number: Int = 1,
        val chars: StringBuilder = StringBuilder(),
    ) {
        override fun toString(): String {
            return buildString {
                repeat(number) {
                    append(chars.toString())
                }
            }
        }
    }
}