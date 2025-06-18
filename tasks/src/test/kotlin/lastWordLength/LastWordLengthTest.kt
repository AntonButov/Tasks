package lastWordLength

import ru.butov.tasks.lastWordLength.LastWordLength
import ru.butov.tasks.lastWordLength.LastWordLengthImpl
import kotlin.test.Test
import kotlin.test.assertEquals

class LastWordLengthTest {

        private val impl: LastWordLength = LastWordLengthImpl()

        @Test
        fun example1() {
            assertEquals(5, impl.length("Hello World"))
        }

        @Test
        fun example2() {
            assertEquals(4, impl.length("   fly me   to   the moon  "))
        }

        @Test
        fun singleWord() {
            assertEquals(6, impl.length("planet"))
        }

        @Test
        fun trailingSpaces() {
            assertEquals(6, impl.length("coding   "))
        }

        @Test
        fun multipleSpacesBetweenWords() {
            assertEquals(6, impl.length("I    enjoy   Kotlin"))
        }

        @Test
        fun onlySpaces() {
            assertEquals(0, impl.length("        "))
        }

        @Test
        fun emptyString() {
            assertEquals(0, impl.length(""))
        }

        @Test
        fun singleCharWord() {
            assertEquals(1, impl.length("a"))
        }

        @Test
        fun punctuation() {
            assertEquals(3, impl.length("go! to it."))
        }
    }
