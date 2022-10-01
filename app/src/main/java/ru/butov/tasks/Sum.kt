package ru.butov.tasks

class Sum {

    fun twoSum(numbers: List<Int>, target: Int): List<Int> {

        val result: List<List<Int>> = numbers.mapIndexed { indexParent, elementParent ->

            numbers
                .subList(indexParent, numbers.size)
                .mapIndexed { index, element ->
                    listOf(indexParent, indexParent + index, element + elementParent)
                }
                .filter { it[2] == target }
                .map { listOf(it[0], it[1]) }

        }.flatten()

        return result.flatten()
    }
}