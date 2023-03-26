package ru.butov.tasks

class MaxIncreaseToKeepCitySkyline {

    fun increase(inputList: List<List<Int>>): List<List<Int>> =
        inputList.mapIndexed { y, list ->
            list.mapIndexed { x, _ ->
                Math.min(inputList.getMaxVertical(x), inputList.getMaxHorizontal(y))
            }
        }

    private fun List<List<Int>>.getMaxHorizontal(y: Int): Int =
        this[y].max()

    private fun List<List<Int>>.getMaxVertical(x: Int): Int =
        map { it[x] }.max()
}