package ru.butov.tasks

// ## 2. Return indexes of element sum which equals terget.
class Sum {

    fun twoSum(numbers: List<Int>, target: Int): List<Int> {

        val result: List<List<Int>> = numbers.flatMapIndexed { indexParent, elementParent ->

            numbers
                .subList(indexParent, numbers.size)
                .mapIndexed { index, element ->
                    listOf(indexParent, indexParent + index, element + elementParent)
                }
                .filter { it[2] == target }
                .map { listOf(it[0], it[1]) }

        }

        return result.flatten()
    }

    fun twoSumN(numbers: List<Int>, target: Int): List<Int> {
        val hs = mutableMapOf<Int, Int>()
        val result = mutableListOf<Int>()
        numbers.forEachIndexed{ index, num ->
            val firstNum = target - num
            if (hs.contains(firstNum)) {
                val indexFirstNum = hs[firstNum]!!
                result.add(indexFirstNum)
                result.add(index)
            }
            hs[num] = index
        }
        return result
    }
}