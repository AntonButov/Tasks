package ru.butov.tasks.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

/**
 * lazy + async: Deferred создаётся один раз (thread-safe),
 * все await() ждут один и тот же вызов API.
 * Scope нужен, потому что async запускает корутину.
 */
class RepositoryLazy(
    private val backendApi: BackendApi,
    private val scope: CoroutineScope,
) {
    private val deferred: Lazy<Deferred<String>> = lazy {
        scope.async { backendApi.apiCall() }
    }

    suspend fun apiCallOrCache(): String = deferred.value.await()
}
