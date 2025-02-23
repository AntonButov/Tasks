package ru.butov.tasks

import Initials
//import InitialsImpl
import org.junit.Assert.assertEquals
import org.junit.Test

class InitialsExtractorTest {

    @Test
    fun `test single first and last name`() {
     //   val initials: Initials = InitialsImpl("John Doe")
     //   assertEquals("J.D.", initials.format())
    }

    @Test
    fun `test three names`() {
     //   val initials: Initials = InitialsImpl("Alice Bob Carol")
     //   assertEquals("A.B.C.", initials.format())
    }

    @Test
    fun `test hyphenated first name`() {
      //  val initials: Initials = InitialsImpl("Jean-Claude Van Damme")
      //  assertEquals("J-C.V.D.", initials.format())
    }

    @Test
    fun `test hyphenated last name`() {
       // val initials: Initials = InitialsImpl("Mary Jane Watson-Parker")
       // assertEquals("M.J.W-P.", initials.format())
    }

    @Test
    fun `test middle name included`() {
       // val initials: Initials = InitialsImpl("Elon Reeve Musk")
      //  assertEquals("E.R.M.", initials.format())
    }
}
