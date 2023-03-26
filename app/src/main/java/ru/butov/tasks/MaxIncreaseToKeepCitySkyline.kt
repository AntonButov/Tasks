package ru.butov.tasks

fun List<List<Int>>.increase(): List<List<Int>> =
    mapIndexed { y, list ->
        List(list.size) { x ->
            getMaxVertical(x).coerceAtMost(getMaxHorizontal(y))
        }
    }

fun List<List<Int>>.difference(list: List<List<Int>>) =
    foldIndexed(0
    ) { index, acc, listVert ->
        acc + listVert.diff(list[index])
    }

private fun List<Int>.diff(list: List<Int>): Int =
    List(size) { index ->
        this[index] - list[index]
    }.sum()

private fun List<List<Int>>.getMaxHorizontal(y: Int): Int =
    this[y].max()

private fun List<List<Int>>.getMaxVertical(x: Int): Int =
    map { it[x] }.max()
