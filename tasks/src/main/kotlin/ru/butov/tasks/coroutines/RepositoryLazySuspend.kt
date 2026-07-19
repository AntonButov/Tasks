package ru.butov.tasks.coroutines

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/**
 * Suspend-аналог lazy: инициализатор вызывается один раз,
 * без CoroutineScope и без Deferred.
 * См. kotlinx.coroutines#706 / паттерн LazySuspend.
 */
fun <T> lazySuspend(initializer: suspend () -> T): LazySuspend<T> = LazySuspend(initializer)

class LazySuspend<T>(private val initializer: suspend () -> T) {
    @Volatile
    private var cached: Any? = UNINITIALIZED
    private val mutex = Mutex()

    val isInitialized: Boolean
        get() = cached !== UNINITIALIZED

    @Suppress("UNCHECKED_CAST")
    fun getOrNull(): T? = cached.takeUnless { it === UNINITIALIZED } as T?

    @Suppress("UNCHECKED_CAST")
    suspend operator fun invoke(): T {
        val existing = cached
        if (existing !== UNINITIALIZED) {
            return existing as T
        }
        return mutex.withLock {
            val doubleCheck = cached
            if (doubleCheck !== UNINITIALIZED) {
                return@withLock doubleCheck as T
            }
            initializer().also { cached = it }
        }
    }

    private companion object {
        val UNINITIALIZED = Any()
    }
}

/**
 * Repository на lazySuspend: scope не нужен.
 */
class RepositoryLazySuspend(backendApi: BackendApi) {
    private val cache = lazySuspend { backendApi.apiCall() }

    suspend fun apiCallOrCache(): String = cache()
}
