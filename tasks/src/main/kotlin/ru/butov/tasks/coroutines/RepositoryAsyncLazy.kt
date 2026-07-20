package ru.butov.tasks.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async

/**
 * Официальный паттерн из kotlinx.coroutines:
 * async(start = LAZY) как замена lazy для suspend.
 * Корутина создаётся сразу, apiCall стартует при первом await().
 */
class RepositoryAsyncLazy(
    private val backendApi: BackendApi,
    scope: CoroutineScope,
) {
    private val deferred: Deferred<String> = scope.async(start = CoroutineStart.LAZY) {
        backendApi.apiCall()
    }

    suspend fun apiCallOrCache(): String = deferred.await()
}
