package ru.butov.tasks

import org.junit.Test
import org.junit.Assert.*

class RomanToIntegerTest {

    private val romanToInteger: RomanToInteger
        get() = RomanToInteger()

    // Basic numerals
    @Test fun testI() = baseTest("I", 1)
    @Test fun testV() = baseTest("V", 5)
    @Test fun testX() = baseTest("X", 10)
    @Test fun testL() = baseTest("L", 50)
    @Test fun testC() = baseTest("C", 100)
    @Test fun testD() = baseTest("D", 500)
    @Test fun testM() = baseTest("M", 1000)

    // Simple numbers
    @Test fun testIII() = baseTest("III", 3)
    @Test fun testVI() = baseTest("VI", 6)
    @Test fun testVIII() = baseTest("VIII", 8)
    @Test fun testXI() = baseTest("XI", 11)

    // Subtractive notation
    @Test fun testIV() = baseTest("IV", 4)
    @Test fun testIX() = baseTest("IX", 9)
    @Test fun testXL() = baseTest("XL", 40)
    @Test fun testXC() = baseTest("XC", 90)
    @Test fun testCD() = baseTest("CD", 400)
    @Test fun testCM() = baseTest("CM", 900)

    // Composite numbers
    @Test fun testLVIII() = baseTest("LVIII", 58)
    @Test fun testMCMXCIV() = baseTest("MCMXCIV", 1994)
    @Test fun testDCXXI() = baseTest("DCXXI", 621)
    @Test fun testMMMCMXCIX() = baseTest("MMMCMXCIX", 3999)

    private fun baseTest(roman: String, num: Int) {
        assertEquals(num, romanToInteger.romanToInt(roman))
    }
}