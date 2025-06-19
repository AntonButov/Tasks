package ru.butov.tasks.coroutines

import kotlin.test.Test

class FibonacciSequenceTest {

    @Test
    fun test() {
        val fibonacci = sequence {
            var cur = 1
            var next = 1
            while (true) {
                yield(cur)             // отдает текущее значение
                val tmp = cur + next   // вычисляет следующее
                cur = next
                next = tmp
            }
        }
        println(fibonacci.iterator())
        println(fibonacci.take(10).toList())
    }

}