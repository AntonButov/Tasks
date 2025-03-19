package ru.butov.tasks

interface ProductArrayExceptSelf

class ProductArrayExceptSelfImpl: ProductArrayExceptSelf {

    fun product(input: List<Int>): List<Int> {
        val result1 = MutableList(input.size) { 1 }
        val result2 = MutableList(input.size) { 1 }
        val result = MutableList(input.size) { 1 }
            input.forEachIndexed { index, num ->
                if (index + 1 < input.size) {
                    result1[index + 1] = result1[index] * num
                }
                result[index] = result1[index] * result2[index]
                val index2 = input.size - 1 - index
                val num2 = input[index2]
                if (index2 - 1 >=  0) {
                    result2[index2 - 1] = result2[index2] * num2
                }
                result[index2] = result1[index2] * result2[index2]
            }
        return result.toList()
    }

}