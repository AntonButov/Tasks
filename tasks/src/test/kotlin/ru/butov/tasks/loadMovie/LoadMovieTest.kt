package ru.butov.tasks.loadMovie

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalCoroutinesApi::class)
class LoadMovieTest {

    val indexies
        get() = listOf(3, 2, 1)

    @Test
    fun loadFast() = runTest {
        val loadMovie = LoadMovieImpl(LoadService(), UnconfinedTestDispatcher(testScheduler))
        val result = loadMovie.loadFast(indexies).toList()
        assertEquals(listOf("movie3", "movie2", "movie1"), result)
    }

    @Test
    fun loadAll() = runTest {
        val loadMovie = LoadMovieImpl(LoadService())
        val result = loadMovie.loadAll(indexies).toList()
        assertEquals(listOf("movie3", "movie2", "movie1"), result)
    }
}