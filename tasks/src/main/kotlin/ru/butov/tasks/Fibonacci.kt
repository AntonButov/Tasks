package ru.butov.tasks

class Fibonacci(private val num: Int) {

    fun getRecursive(): Int {
        if (num == 1) error("Can not bee 1.")
        return getRecursive(num)
    }

    private fun getRecursive(n: Int): Int {
        if (n == 2) return 2
        if (n == 3) return 3
        return getRecursive(n - 2) + getRecursive(n - 1)
    }

    fun get(): Int {
        var prev = 1
        var current = 2
        var result = num
        (3 .. num).forEach { _ ->
            result = prev + current
            prev = current
            current = result
        }
        return result
    }
 }