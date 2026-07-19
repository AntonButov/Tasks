package ru.butov.tasks.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.stateIn

interface BackendApiFlow {
    // very long call
    fun apiCall(): Flow<String>
}

// Сделать код-ревью и рефакторинг по необходимости
class RepositoryFlow(
    backendApiFlow: BackendApiFlow,
    scope: CoroutineScope,
) {
    val cache: StateFlow<String?> = backendApiFlow.apiCall()
        .stateIn(
            scope = scope,
            started = SharingStarted.Lazily,
            initialValue = null,
        )

    fun apiCallOrCache(): Flow<String> = cache.filterNotNull()
}
