package ru.butov.tasks.loadMovie

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class LoadMovieTest {

    @Test
    fun loadFast() = runBlocking {
        val loadMovie = LoadMovieImpl(LoadService())
        val result = loadMovie.loadFast(listOf(3,2,1)).toList()
        assertEquals(listOf("movie1", "movie2", "movie3"), result)
    }

    @Test
    fun loadAll() = runBlocking {
        val loadMovie = LoadMovieImpl(LoadService())
        val result = loadMovie.loadByOrder(listOf(1,2,3)).toList()
        assertEquals(listOf("movie1", "movie2", "movie3"), result)
    }
}