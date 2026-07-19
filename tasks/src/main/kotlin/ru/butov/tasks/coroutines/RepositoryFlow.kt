package ru.butov.tasks.coroutines

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

interface BackendApiFlow {
    // very long call
    fun apiCall(): Flow<String>
}

// Сделать код-ревью и рефакторинг по необходимости
class RepositoryFLow(private val backendApiFLow: BackendApiFlow) {
    private val cache: Flow<String> by lazy { backendApiFLow.apiCall() }
    private val mutex = Mutex()

    fun apiCallOrCache(): Flow<String> {
        return cache
    }
}
