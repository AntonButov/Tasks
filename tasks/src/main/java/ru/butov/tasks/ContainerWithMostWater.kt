package ru.butov.tasks

class ContainerWithMostWater {

    fun getMostWater(list: List<Int>): Int =
        list.mapIndexed { index, _ ->
            list.subList(index, list.count())
        }
            .map { it.toSpace() }
            .flatten()
            .maxBy { it }

    private fun List<Int>.toSpace(): List<Int> =
        mapIndexed { index, element ->
            Math.min(get(0), element) * index
        }
}