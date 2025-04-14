package ru.butov.tasks.elegantobjects

import kotlin.test.Test

class BeImmutableSideEffectTest {

    class Cash(private var price: Int) {
        fun mul(time: Int) {
            price *=time
        }
        fun print() {
            println(price)
        }
    }

    @Test
    fun sideEffect() {
        val five = Cash(5)
        // We have new price
        five.mul(2)
        five.print() // $10 oops
    }

}