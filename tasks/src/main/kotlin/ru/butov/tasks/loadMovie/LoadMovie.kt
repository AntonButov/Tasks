package ru.butov.tasks.loadMovie

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface LoadMovie {
    fun loadFast(indexes: List<Int>): Flow<String>
    fun loadByOrder(indexes: List<Int>): Flow<String>
    fun loadByOrderConcat(indexes: List<Int>): Flow<String>
}

class LoadService() {

    suspend fun loadById(id: Int): String {
        delay(id * 1000L)
        return "movie$id"
    }
}

class LoadMovieImpl(
    private val loadService: LoadService,
) : LoadMovie {
    override fun loadFast(indexes: List<Int>): Flow<String> = indexes.asFlow()
        .flatMapMerge { index ->
            flow {
                val result = loadService.loadById(index)
                emit(result)
            }
        }


    override fun loadByOrder(indexes: List<Int>): Flow<String> = flow {
        coroutineScope {
            val results = indexes.map { index ->
                async { loadService.loadById(index) }
            }.awaitAll()
            results.forEach { emit(it) }
        }
    }

    override fun loadByOrderConcat(indexes: List<Int>): Flow<String> = indexes.asFlow()
        .flatMapConcat { index ->
            flow {
                emit(loadService.loadById(index))
            }
        }
}

