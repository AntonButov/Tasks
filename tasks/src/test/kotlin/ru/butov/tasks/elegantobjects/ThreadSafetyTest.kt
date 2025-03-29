package ru.butov.tasks.elegantobjects

import kotlin.test.Test

class ThreadSafetyTest {

    data class MutableName(var value: String)

    @Test
    fun mutableTest() {
        val mutableName = MutableName("Anton")
        Thread { mutableName.value = "Thread 1" }.start()
        Thread { mutableName.value = "Thread 2" }.start()
        println(mutableName.value) // 🤯 unpredictable
    }

    data class ImmutableName(val value: String)

    @Test
    fun immutableTest() {
        val immutableName = ImmutableName("Anton")
        Thread {
            val rename = immutableName.copy(value = "Thread-safe")
            println(rename) // Thread-safe
        }.start()
        println(immutableName) // Anton
    }
}
