package ru.butov.tasks

import org.junit.Assert.assertEquals
import kotlin.test.Test

class GuavaTest {

    private val initials = InitialsImpl()

    @Test
    fun testSimpleTwoWords() {
        assertEquals("DL", initials.initials("Denis Lee"))
        assertEquals("MZ", initials.initials("Mark Zuckerberk"))
        assertEquals("YA", initials.initials("Yunis Abdulzade"))
    }

    @Test
    fun testWithThreeWords() {
        assertEquals("RA", initials.initials("Rahim Fatih Abdul-Zade"))
    }

    private val rounded = RoundedImpl()

    @Test
    fun testCalculationAndRounding() {
        val input = 123.456789
        val result: Double = rounded.round(input)

        // 123.456789 / 13 = 9.496675307692308
        // * 5 = 47.48337653846154
        // округление до 4 знаков = 47.4834
        kotlin.test.assertEquals(47.4834, result)
    }

    @Test
    fun testExactNumber() {
        val input = 130.0
        val result = rounded.round(input)

        // 130 / 13 = 10
        // * 5 = 50
        // округление до 4 знаков = 50.0
        kotlin.test.assertEquals(50.0, result)
    }

    @Test
    fun testSmallNumber() {
        val input = 1.0
        val result = rounded.round(input)

        // 1 / 13 = 0.0769230769
        // * 5 = 0.3846153846
        // округление = 0.3846
        kotlin.test.assertEquals(0.3846, result)
    }
}