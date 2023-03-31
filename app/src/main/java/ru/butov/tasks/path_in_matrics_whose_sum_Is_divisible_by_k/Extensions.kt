package ru.butov.tasks.path_in_matrics_whose_sum_Is_divisible_by_k

fun List<Int>.addElement(element: Int, k: Int): List<Int> =
    if (isEmpty()) listOf(element)
    else map {
        val res = it + element
        if (res >= k) res % k
        else res
    }

fun List<Int>.groupByK(k: Int): List<Int> =
    groupBy {
        it
    }.values
        .flatten()
        .orderByK(k)

private fun List<Int>.orderByK(k: Int): List<Int> =
    buildList {
        repeat(k) { valueK ->
            add(this@orderByK.filter { it == valueK }.size)
        }
    }

fun List<Int>.squash(): List<Int> =
    buildList {
        this@squash.forEachIndexed { k, element ->
            repeat(element) {
                if (element != 0) {
                    add(k)
                }
            }
        }
    }

fun List<Int>.addCaches(elementCache: List<Int>): List<Int> {
    return mapIndexed { index, element ->
        element + elementCache[index]
    }
}
