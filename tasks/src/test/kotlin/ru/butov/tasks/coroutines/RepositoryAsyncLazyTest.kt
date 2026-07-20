package ru.butov.tasks.coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import java.util.concurrent.atomic.AtomicInteger
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RepositoryAsyncLazyTest {

    @Test
    fun returnsCachedValueOnSecondCall() = runBlocking {
        val callCount = AtomicInteger(0)
        val repository = RepositoryAsyncLazy(
            backendApi = object : BackendApi {
                override suspend fun apiCall(): String {
                    callCount.incrementAndGet()
                    return "cached"
                }
            },
            scope = this,
        )

        assertEquals(0, callCount.get())
        assertEquals("cached", repository.apiCallOrCache())
        assertEquals("cached", repository.apiCallOrCache())
        assertEquals(1, callCount.get())
    }

    @Test
    fun concurrentCallsInvokeApiOnlyOnce() = runBlocking {
        val callCount = AtomicInteger(0)
        val repository = RepositoryAsyncLazy(
            backendApi = object : BackendApi {
                override suspend fun apiCall(): String {
                    callCount.incrementAndGet()
                    delay(50)
                    return "result"
                }
            },
            scope = this,
        )

        coroutineScope {
            repeat(100) {
                launch(Dispatchers.Default) {
                    assertEquals("result", repository.apiCallOrCache())
                }
            }
        }

        assertEquals(1, callCount.get())
    }

    @Test
    fun concurrentAsyncCallsShareSameResult() = runBlocking {
        val callCount = AtomicInteger(0)
        val repository = RepositoryAsyncLazy(
            backendApi = object : BackendApi {
                override suspend fun apiCall(): String {
                    callCount.incrementAndGet()
                    delay(50)
                    return "shared"
                }
            },
            scope = this,
        )

        val results = coroutineScope {
            List(50) {
                async(Dispatchers.Default) { repository.apiCallOrCache() }
            }.awaitAll()
        }

        assertTrue(results.all { it == "shared" })
        assertEquals(1, callCount.get())
    }
}
