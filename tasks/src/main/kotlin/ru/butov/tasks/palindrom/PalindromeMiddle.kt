package ru.butov.tasks.palindrom

class PalindromeMiddle {

    fun getLongest(input: String): Int {
        if (input.isEmpty()) return 0
        if (input.length == 1) return 1
        var max = 0
        input.forEachIndexed { index, char ->
            val isDoubleCorrection: Boolean = input.getOrNull(index - 1) == char
            if (isDoubleCorrection) {
                max = maxOf(max, findPalindromeFrom(input, index, isDoubleCorrection))
            }
            max = maxOf(max, findPalindromeFrom(input, index))
        }
        return max
    }

    companion object {

        fun findPalindromeFrom(input: String, point: Int, isDoubleCorrection: Boolean = false): Int {
            var max = 1
            while (input.isPalindrome(point, max, isDoubleCorrection)) ++max
            --max
            return 2 * max + if (isDoubleCorrection) 2 else 1
        }

        private fun String.isPalindrome(point: Int, radius: Int, isDouble: Boolean = false): Boolean {
            val isDoubleCorrection = if (isDouble) 1 else 0
            val leftIndex = point - radius - isDoubleCorrection
            if (leftIndex <0) return false
            val rightIndex = point + radius
            if (rightIndex > length - 1) return false
            val leftChar = get(leftIndex)
            val rightChar = get(rightIndex)
            return leftChar == rightChar
        }
    }
}