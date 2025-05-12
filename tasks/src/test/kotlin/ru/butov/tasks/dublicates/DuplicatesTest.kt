package ru.butov.tasks.dublicates

import kotlin.test.Test
import kotlin.test.assertEquals

class DuplicatesTest {

    private val duplicates: Duplicates
        get() = DuplicatesImpl()


    @Test
    fun hasDuplicate() {
        // nums = [1, 2, 3, 1] → true
        assertEquals(true, duplicates.isDouble(listOf(1, 2, 3, 1)))
    }

    @Test
    fun allUnique() {
        // nums = [1, 2, 3, 4] → false
        assertEquals(false, duplicates.isDouble(listOf(1, 2, 3, 4)))
    }

    @Test
    fun allSame() {
        // nums = [5, 5, 5, 5] → true
        assertEquals(true, duplicates.isDouble(listOf(5, 5, 5, 5)))
    }

    @Test
    fun singleElement() {
        // nums = [42] → false
        assertEquals(false, duplicates.isDouble(listOf(42)))
    }

    @Test
    fun emptyList() {
        // nums = [] → false
        assertEquals(false, duplicates.isDouble(kotlin.collections.emptyList()))
    }
}