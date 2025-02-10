package ru.butov.tasks

import InitialsImpl
import org.junit.Test

class InitialsExtractorTest {

    @Test
    fun `test single first and last name`() {
        val initials = InitialsImpl("John Doe")
       // assertEquals("J.D.", initials.format())
    }

    @Test
    fun `test three names`() {
        val initials = InitialsImpl("Alice Bob Carol")
       // assertEquals("A.B.C.", initials.format())
    }

    @Test
    fun `test hyphenated first name`() {
        val initials = InitialsImpl("Jean-Claude Van Damme")
      //  assertEquals("J-C.V.D.", initials.format())
    }

    @Test
    fun `test hyphenated last name`() {
        val initials = InitialsImpl("Mary Jane Watson-Parker")
     //   assertEquals("M.J.W-P.", initials.format())
    }

    @Test
    fun `test middle name included`() {
        val initials = InitialsImpl("Elon Reeve Musk")
     //   assertEquals("E.R.M.", initials.format())
    }
}
