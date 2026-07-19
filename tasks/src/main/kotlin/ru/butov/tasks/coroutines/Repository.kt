package ru.butov.tasks.coroutines

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

interface BackendApi {
    // very long call
    suspend fun apiCall(): String
}

// Сделать код-ревью и рефакторинг по необходимости
class Repository(private val backendApi: BackendApi) {
    @Volatile
    private var cache: String? = null
    private val mutex = Mutex()

    suspend fun apiCallOrCache(): String {
        if (cache == null) {
            mutex.withLock {
                if (cache != null) {
                    return cache!!
                }
                cache = backendApi.apiCall()
            }
        }
        return cache!!
    }
}
