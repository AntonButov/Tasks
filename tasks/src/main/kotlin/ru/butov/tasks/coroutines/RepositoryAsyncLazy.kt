package ru.butov.tasks.coroutines

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import java.util.concurrent.atomic.AtomicReference

/**
 * Single-flight без CoroutineScope в конструкторе.
 *
 * Чистый async(start = LAZY) всегда требует scope — без него зависания
 * через coroutineScope при гонках. Здесь тот же смысл через CompletableDeferred:
 * первый вызов запускает apiCall, остальные await() ждут один Deferred.
 */
class RepositoryAsyncLazy(
    private val backendApi: BackendApi,
) {
    private val deferred = AtomicReference<Deferred<String>?>(null)

    suspend fun apiCallOrCache(): String {
        deferred.get()?.let { return it.await() }

        val created = CompletableDeferred<String>()
        if (deferred.compareAndSet(null, created)) {
            try {
                created.complete(backendApi.apiCall())
            } catch (e: Throwable) {
                created.completeExceptionally(e)
                throw e
            }
        }
        return deferred.get()!!.await()
    }
}
