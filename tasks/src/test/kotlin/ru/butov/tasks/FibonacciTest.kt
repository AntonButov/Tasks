package ru.butov.tasks

import org.junit.Test
import kotlin.test.assertEquals

class FibonacciTest {

    @Test
    fun twoCase() {
        val fibonacci = Fibonacci(2)
        assertEquals(2, fibonacci.getRecursive())
        assertEquals(2, fibonacci.get())
    }

    @Test
    fun threeCase() {
        val fibonacci = Fibonacci(3)
        assertEquals(3, fibonacci.getRecursive())
        assertEquals(3, fibonacci.get())
    }

    @Test
    fun thorCase() {
        val fibonacci = Fibonacci(4)
        assertEquals(5, fibonacci.getRecursive())
        assertEquals(5, fibonacci.get())
    }

    @Test
    fun fiveCase() {
        val fibonacci = Fibonacci(5)
        assertEquals(8, fibonacci.getRecursive())
        assertEquals(8, fibonacci.get())
    }

}