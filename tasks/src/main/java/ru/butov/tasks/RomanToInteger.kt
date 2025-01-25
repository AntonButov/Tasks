package ru.butov.tasks

class RomanToInteger {

    fun romanToInt(s: String): Int {
        val zip = s.zipWithNext { a, b ->
                if (a.symbolToInt() < b.symbolToInt())
                    - a.symbolToInt()
                else
                    a.symbolToInt()
            }
        val zipPlusLast = buildList {
            addAll(zip)
            add(s.last().symbolToInt())
        }
        val res = zipPlusLast.reduce {
                acc, i -> acc + i
            }
        return res
    }

    private fun Char.symbolToInt(): Int =
        when (this) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> throw IllegalArgumentException("Wrong roman.")
        }
}