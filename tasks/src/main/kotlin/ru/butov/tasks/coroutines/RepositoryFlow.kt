package ru.butov.tasks.coroutines

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

interface BackendApiFlow {
    // very long call
    fun apiCall(): Flow<String>
}

// Сделать код-ревью и рефакторинг по необходимости
class RepositoryFlow(private val backendApiFlow: BackendApiFlow) {
    private val _cache = MutableStateFlow<String?>(null)
    val cache = _cache.asStateFlow()
    private val mutex = Mutex()

    fun apiCallOrCache(): Flow<String> = flow {
        _cache.value?.let {
            emit(it)
            return@flow
        }
        mutex.withLock {
            _cache.value?.let {
                emit(it)
                return@withLock
            }
            val value = backendApiFlow.apiCall().first()
            _cache.value = value
            emit(value)
        }
    }
}
