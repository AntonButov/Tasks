package ru.butov.tasks.decodestring

class DecodeString {

    fun decode(input: String): String = decodeInternal(input, 0).first

    private fun decodeInternal(input: String, level: Int): Pair<String, Int> {

        var index = 0
        val result = StringBuilder()
        val thing = Thing(1)

        fun printResult() {
            result.append(thing.toString())
            thing.number = 1
            thing.chars.clear()
        }

        while (index < input.length) {
            val char = input[index]
            if (char == ']') {
                if (level > 0) {
                    break
                }
                printResult()
                index++
                continue
            }
            if (char.isDigit()) {
                if (index == 0) {
                    val numString = StringBuilder()
                    while (input[index] != '[') {
                        val currentChar = input[index]
                        numString.append(currentChar)
                        index++
                    }
                    thing.number = numString.toString().toInt()
                    index++
                    continue
                }
                val internalStringWithLength = decodeInternal(input.substring(index), level + 1)
                thing.chars.append(internalStringWithLength.first)
                index += internalStringWithLength.second + 1
                continue
            }
            index++
            thing.chars.append(char) // todo должны еще раз вызвать decode
        }
        printResult()
        return result.toString() to index
    }

    class Thing(
        var number: Int,
        val chars: StringBuilder = StringBuilder(),
    ) {
        override fun toString(): String {
            return buildString {
                (1..number).forEach { _ ->
                    append(chars)
                }
            }
        }
    }

}