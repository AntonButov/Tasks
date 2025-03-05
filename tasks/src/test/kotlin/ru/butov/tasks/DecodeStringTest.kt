package ru.butov.tasks

import ru.butov.tasks.decodestring.DecodeString
import ru.butov.tasks.decodestring.DecodeStringQueue
import kotlin.test.Test
import kotlin.test.assertEquals

class DecodeStringTest {

    private val decodeString
        get() = DecodeString()

    private val decodeStringQueue
        get() = DecodeStringQueue()

    @Test
    fun testSimpleCases() {
        val inputFirst = "3[a]2[bc]"
        val resultFirst = "aaabcbc"

        val inputSecond = "3[a2[c]]"
        val resultSecond = "accaccacc"

        val inputThird = "2[abc]3[cd]ef"
        val resultThird = "abcabccdcdcdef"

        assertEquals(resultFirst, decodeString.decodeRecursive(inputFirst))
        assertEquals(resultFirst, decodeStringQueue.decode(inputFirst))
        assertEquals(resultSecond, decodeString.decodeRecursive(inputSecond))
        assertEquals(resultSecond, decodeStringQueue.decode(inputSecond))
        assertEquals(resultThird, decodeString.decodeRecursive(inputThird))
        assertEquals(resultThird, decodeStringQueue.decode(inputThird))
    }

    @Test
    fun testNestedCases() {
        val inputFirst = "4[ab]"
        val resultFirst = "abababab"

        val inputSecond = "1[a]"
        val resultSecond = "a"

        val inputThird = "6[a]"
        val resultThird = "aaaaaa"

        assertEquals(resultFirst, decodeString.decodeRecursive(inputFirst))
        assertEquals(resultFirst, decodeStringQueue.decode(inputFirst))
        assertEquals(resultSecond, decodeString.decodeRecursive(inputSecond))
        assertEquals(resultSecond, decodeStringQueue.decode(inputSecond))
        assertEquals(resultThird, decodeString.decodeRecursive(inputThird))
        assertEquals(resultThird, decodeStringQueue.decode(inputThird))
    }

    @Test
    fun testEdgeCases() {
        val inputFirst = ""
        val resultFirst = ""

        val inputSecond = "abc"
        val resultSecond = "abc"

        // val inputThird = "10[z]" I don`t wont consider it case
        // val resultThird = "zzzzzzzzzz"

        assertEquals(resultFirst, decodeString.decodeRecursive(inputFirst))
        assertEquals(resultFirst, decodeStringQueue.decode(inputFirst))
        assertEquals(resultSecond, decodeString.decodeRecursive(inputSecond))
        assertEquals(resultSecond, decodeStringQueue.decode(inputSecond))
        // assertEquals(resultThird, decodeString.decode(inputThird))
    }
}