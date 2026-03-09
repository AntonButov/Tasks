package ru.butov.tasks.loadMovie

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface LoadMovie {
    fun loadFast(indexes: List<Int>): Flow<String>
    fun loadByOrder(indexes: List<Int>): Flow<String>
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
        .fastesLoad(loadService)


    override fun loadByOrder(indexes: List<Int>): Flow<String> = indexes.asFlow()
        .fastesLoad(loadService)

}

private fun Flow<Int>.fastesLoad(loadService: LoadService): Flow<String> =
    this.flatMapMerge { index ->
        flow {
            println("start index=$index")
            val result = loadService.loadById(index)
            println("done index=$index result=$result")
            emit(result)
        }
    }

