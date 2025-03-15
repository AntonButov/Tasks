package ru.butov.tasks.elegantobjects

import kotlin.test.Test

class FailureAtomicityTest {

    class MutableCash(
        var dollar: Int,
        var cent: Int
    ) {
        @Throws(Exception::class)
        fun mul(factor: Int) {
            val dollarsBefore = dollar
            dollar *= factor
            if (this.cent * factor > 99) {
                dollar = dollarsBefore
                throw Exception("Too big cents")
            }
            cent *= factor
        }
    }

    class ImmutableCash(
        val dollar: Int,
        val cent: Int
    ) {
        @Throws(Exception::class)
        fun mul(factor: Int): ImmutableCash {
            if ((cent * factor) > 99) {
                throw IllegalArgumentException("Too big cents")
            }
            return ImmutableCash(dollar * factor, cent * factor)
        }
    }

}