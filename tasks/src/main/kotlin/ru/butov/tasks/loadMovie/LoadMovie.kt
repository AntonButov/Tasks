package ru.butov.tasks.loadMovie

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.flowOn
import kotlin.random.Random

interface LoadMovie {
    fun loadFast(indexes: List<Int>): Flow<String>
    fun loadAll(indexes: List<Int>): Flow<String>
}

class LoadService() {

    suspend fun loadById(id: Int): String {
        delay(id * 1000L)
        return "movie$id"
    }
}

class LoadMovieImpl(
    private val loadService: LoadService,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : LoadMovie {
    override fun loadFast(indexes: List<Int>): Flow<String> = indexes.asFlow()
        .flatMapMerge {
            val result = loadService.loadById(it)
            println("emit $it")
            flowOf(result)
        }.flowOn(dispatcher)



    override fun loadAll(indexes: List<Int>): Flow<String> = flow {
        indexes.forEach {
            val result = loadService.loadById(it)
            println("emit $it")
            emit(result)
        }
    }
}

