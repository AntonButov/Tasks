package ru.butov.tasks

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import ru.butov.tasks.window.Window
import ru.butov.tasks.window.WindowImpl
import kotlin.test.Test

class WindowTest {
    val window: Window
        get() = WindowImpl()


    @Test
    fun `should find subarray when sum exists in the middle`() {
        val result = window.getWindow(listOf(1, 4, 20, 3, 10, 5), 33)
        assertEquals(listOf(20, 3, 10), result)
    }

    @Test
    fun `should return null when no subarray adds up to target`() {
        val result = window.getWindow(listOf(1, 2, 3, 4, 5), 100)
        assertNull(result)
    }

    @Test
    fun `should find subarray with zero values`() {
        val result = window.getWindow(listOf(1, 4, 0, 0, 3, 10, 5), 7)
        assertEquals(listOf(4, 0, 0, 3), result)
    }

    @Test
    fun `should find full array as subarray`() {
        val result = window.getWindow(listOf(5, 5, 5), 15)
        assertEquals(listOf(5, 5, 5), result)
    }

    @Test
    fun `should find subarray at the start`() {
        val result = window.getWindow(listOf(5, 10, 20), 15)
        assertEquals(listOf(5, 10), result)
    }

    @Test
    fun `should handle single-element array matching target`() {
        val result = window.getWindow(listOf(10), 10)
        assertEquals(listOf(10), result)
    }

    @Test
    fun `should return null for empty array`() {
        val result = window.getWindow(listOf(),5)
        assertNull(result)
    }
}