package ru.butov.tasks

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class RomanToIntegerTest {

    private val romanToInteger: RomanToInteger
    get() = RomanToInteger()

    @Test
    fun first() {
        baseTest("III", 3)
    }

    @Test
    fun second() {
        baseTest("IV", 4)
    }

    @Test
    fun three() {
        baseTest("LVIII", 58)
    }

    @Test
    fun four() {
        baseTest("MCMXCIV", 1994)
    }

    private fun baseTest(roman: String, num: Int) {
        assertEquals(num, romanToInteger.romanToInt(roman))
    }
}