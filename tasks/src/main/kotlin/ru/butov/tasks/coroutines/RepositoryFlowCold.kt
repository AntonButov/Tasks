package ru.butov.tasks.coroutines

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * Cold Flow + Mutex: без CoroutineScope.
 * Кэш пишется вручную, API вызывается один раз при конкурентных collect.
 */
class RepositoryFlowCold(private val backendApiFlow: BackendApiFlow) {
    @Volatile
    private var cache: String? = null
    private val mutex = Mutex()

    fun apiCallOrCache(): Flow<String> = flow {
        cache?.let {
            emit(it)
            return@flow
        }
        mutex.withLock {
            cache?.let {
                emit(it)
                return@withLock
            }
            val value = backendApiFlow.apiCall().first()
            cache = value
            emit(value)
        }
    }
}
