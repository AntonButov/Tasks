package ru.butov.tasks.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.assertEquals
import kotlin.test.assertNull

class RepositoryFlowTest {

    @Test
    fun returnsCachedValueOnSecondCall() = runBlocking {
        val callCount = AtomicInteger(0)
        val repository = RepositoryFlow(object : BackendApiFlow {
            override fun apiCall() = flow {
                callCount.incrementAndGet()
                emit("cached")
            }
        })

        assertNull(repository.cache.value)
        assertEquals("cached", repository.apiCallOrCache().first())
        assertEquals("cached", repository.cache.value)
        assertEquals("cached", repository.apiCallOrCache().first())
        assertEquals(1, callCount.get())
    }

    @Test
    fun concurrentCallsInvokeApiOnlyOnce() = runBlocking {
        val callCount = AtomicInteger(0)
        val repository = RepositoryFlow(object : BackendApiFlow {
            override fun apiCall() = flow {
                callCount.incrementAndGet()
                delay(50)
                emit("result")
            }
        })

        coroutineScope {
            repeat(100) {
                launch(Dispatchers.Default) {
                    assertEquals("result", repository.apiCallOrCache().first())
                }
            }
        }

        assertEquals(1, callCount.get())
        assertEquals("result", repository.cache.value)
    }
}
