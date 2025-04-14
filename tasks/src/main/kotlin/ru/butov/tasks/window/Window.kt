package ru.butov.tasks.window

interface Window {
    fun getWindow(input: List<Int>, number: Int): List<Int>?
}

class WindowImpl : Window {
    override fun getWindow(input: List<Int>, number: Int): List<Int>? {
        if (input.isEmpty()) return null
        var firstIndex = 0
        var lastIndex = 0
        var currentSum = input[0]
        do  {
            when {
                currentSum == number -> return input.subList(firstIndex, lastIndex + 1)
                currentSum > number -> {
                    currentSum -= input[firstIndex]
                    firstIndex++
                }
                else -> {
                    lastIndex++
                    if (lastIndex == input.size) return null
                    currentSum += input[lastIndex]
                }
            }
        } while (true)
    }

}