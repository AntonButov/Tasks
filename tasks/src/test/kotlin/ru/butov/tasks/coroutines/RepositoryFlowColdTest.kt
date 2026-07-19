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

class RepositoryFlowColdTest {

    @Test
    fun returnsCachedValueOnSecondCall() = runBlocking {
        val callCount = AtomicInteger(0)
        val repository = RepositoryFlowCold(
            backendApiFlow = object : BackendApiFlow {
                override fun apiCall() = flow {
                    callCount.incrementAndGet()
                    emit("cached")
                }
            },
        )

        assertEquals("cached", repository.apiCallOrCache().first())
        assertEquals("cached", repository.apiCallOrCache().first())
        assertEquals(1, callCount.get())
    }

    @Test
    fun concurrentCallsInvokeApiOnlyOnce() = runBlocking {
        val callCount = AtomicInteger(0)
        val repository = RepositoryFlowCold(
            backendApiFlow = object : BackendApiFlow {
                override fun apiCall() = flow {
                    callCount.incrementAndGet()
                    delay(50)
                    emit("result")
                }
            },
        )

        coroutineScope {
            repeat(100) {
                launch(Dispatchers.Default) {
                    assertEquals("result", repository.apiCallOrCache().first())
                }
            }
        }

        assertEquals(1, callCount.get())
    }
}
