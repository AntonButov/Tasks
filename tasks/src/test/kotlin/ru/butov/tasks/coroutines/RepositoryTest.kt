package ru.butov.tasks.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.assertEquals

class RepositoryTest {

    @Test
    fun returnsCachedValueOnSecondCall() = runBlocking {
        val callCount = AtomicInteger(0)
        val repository = Repository(object : BackendApi {
            override suspend fun apiCall(): String {
                callCount.incrementAndGet()
                return "cached"
            }
        })

        assertEquals("cached", repository.apiCallOrCache())
        assertEquals("cached", repository.apiCallOrCache())
        assertEquals(1, callCount.get())
    }

    @Test
    fun concurrentCallsInvokeApiOnlyOnce() = runBlocking {
        val callCount = AtomicInteger(0)
        val repository = Repository(object : BackendApi {
            override suspend fun apiCall(): String {
                callCount.incrementAndGet()
                delay(50)
                return "result"
            }
        })

        coroutineScope {
            repeat(100) {
                launch(Dispatchers.Default) {
                    assertEquals("result", repository.apiCallOrCache())
                }
            }
        }

        assertEquals(1, callCount.get())
    }
}
