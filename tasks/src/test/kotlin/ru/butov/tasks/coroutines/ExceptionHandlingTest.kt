package ru.butov.tasks.coroutines

import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(DelicateCoroutinesApi::class)
class ExceptionHandlingTest {

    @Test
    fun launchVsAsyncExceptionHandling() = runBlocking {
        val messages = mutableListOf<String>()

        val job = GlobalScope.launch {
            messages.add("Throwing exception from launch")
            throw IndexOutOfBoundsException()
            // Will be printed to the console
        }
        job.join()
        messages.add("Joined failed job")

        val deferred = GlobalScope.async {
            messages.add("Throwing exception from async")
            throw ArithmeticException()
            // Nothing is printed, relying on user to call await
        }

        var caughtArithmeticException = false
        try {
            deferred.await()
            messages.add("Unreached")
        } catch (e: ArithmeticException) {
            messages.add("Caught ArithmeticException")
            caughtArithmeticException = true
        }

        assertTrue(messages.contains("Throwing exception from launch"))
        assertTrue(messages.contains("Joined failed job"))
        assertTrue(messages.contains("Throwing exception from async"))
        assertTrue(messages.contains("Caught ArithmeticException"))
        assertTrue(caughtArithmeticException)
        assertTrue(!messages.contains("Unreached"))
    }
}
