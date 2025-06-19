package lastWordLength

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.butov.tasks.lastWordLength.LastWordLengthGptImpl
import ru.butov.tasks.lastWordLength.LastWordLengthImpl

class LastWordLengthTest {

    private val lastWordLengthImpl = LastWordLengthImpl()
    private val lastWordLengthGptImpl = LastWordLengthGptImpl()

    @Test
    fun testLength() {
        val input = "Hello World"
        val expected = 5

        assertEquals(expected, lastWordLengthImpl.length(input))
        assertEquals(expected, lastWordLengthGptImpl.length(input))
    }

    @Test
    fun testLengthWithTrailingSpaces() {
        val input = "Hello World   "
        val expected = 5

        assertEquals(expected, lastWordLengthImpl.length(input))
        assertEquals(expected, lastWordLengthGptImpl.length(input))
    }

    @Test
    fun testLengthWithSingleWord() {
        val input = "Hello"
        val expected = 5

        assertEquals(expected, lastWordLengthImpl.length(input))
        assertEquals(expected, lastWordLengthGptImpl.length(input))
    }

    @Test
    fun testLengthWithEmptyString() {
        val input = ""
        val expected = 0

        assertEquals(expected, lastWordLengthImpl.length(input))
        assertEquals(expected, lastWordLengthGptImpl.length(input))
    }

    @Test
    fun testLengthWithSpacesOnly() {
        val input = "     "
        val expected = 0

        assertEquals(expected, lastWordLengthImpl.length(input))
        assertEquals(expected, lastWordLengthGptImpl.length(input))
    }
}