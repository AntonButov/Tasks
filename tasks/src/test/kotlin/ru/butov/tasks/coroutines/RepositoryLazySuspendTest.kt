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
import kotlin.test.assertFalse
import kotlin.test.assertNull
import kotlin.test.assertTrue

class RepositoryLazySuspendTest {

    @Test
    fun returnsCachedValueOnSecondCall() = runBlocking {
        val callCount = AtomicInteger(0)
        val repository = RepositoryLazySuspend(
            backendApi = object : BackendApi {
                override suspend fun apiCall(): String {
                    callCount.incrementAndGet()
                    return "cached"
                }
            },
        )

        assertEquals("cached", repository.apiCallOrCache())
        assertEquals("cached", repository.apiCallOrCache())
        assertEquals(1, callCount.get())
    }

    @Test
    fun concurrentCallsInvokeApiOnlyOnce() = runBlocking {
        val callCount = AtomicInteger(0)
        val repository = RepositoryLazySuspend(
            backendApi = object : BackendApi {
                override suspend fun apiCall(): String {
                    callCount.incrementAndGet()
                    delay(50)
                    return "result"
                }
            },
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
    fun lazySuspendExposesInitializationState() = runBlocking {
        val callCount = AtomicInteger(0)
        val lazy = lazySuspend {
            callCount.incrementAndGet()
            delay(10)
            "value"
        }

        assertFalse(lazy.isInitialized)
        assertNull(lazy.getOrNull())

        assertEquals("value", lazy())
        assertTrue(lazy.isInitialized)
        assertEquals("value", lazy.getOrNull())
        assertEquals("value", lazy())
        assertEquals(1, callCount.get())
    }

    @Test
    fun concurrentAsyncCallsShareSameResult() = runBlocking {
        val callCount = AtomicInteger(0)
        val repository = RepositoryLazySuspend(
            backendApi = object : BackendApi {
                override suspend fun apiCall(): String {
                    callCount.incrementAndGet()
                    delay(50)
                    return "shared"
                }
            },
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
