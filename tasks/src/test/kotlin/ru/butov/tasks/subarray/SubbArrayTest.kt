package ru.butov.tasks.subarray

import kotlin.test.Test
import kotlin.test.assertEquals

class SubbArrayTest {

    val subarray: Subarray
        get() = SubbArrayImpl()
    val subarrayOpt: Subarray
        get() = SubbArrayOptImpl()

        @Test
        fun basicCase() {
            // nums = [1, -1, 5, -2, 3], k = 3
            // Подмассив: [1, -1, 5, -2] сумма = 3, длина = 4
            assertEquals(4, subarray.getNum(listOf(1, -1, 5, -2, 3), 3))
            assertEquals(4, subarrayOpt.getNum(listOf(1, -1, 5, -2, 3), 3))
        }

        @Test
        fun anotherExample() {
            // nums = [-2, -1, 2, 1], k = 1
            // Подмассив: [2, -1] сумма = 1, длина = 2
            assertEquals(2, subarray.getNum(listOf(-2, -1, 2, 1), 1))
            assertEquals(2, subarrayOpt.getNum(listOf(-2, -1, 2, 1), 1))
        }

        @Test
        fun noSubarray() {
            // nums = [1, 2, 3], k = 7
            // Нет подмассива с суммой 7 → результат = 0
            assertEquals(0, subarray.getNum(listOf(1, 2, 3), 7))
            assertEquals(0, subarrayOpt.getNum(listOf(1, 2, 3), 7))
        }

        @Test
        fun entireArray() {
            // nums = [1, 2, 3, 4], k = 10
            // Подмассив: [1, 2, 3, 4] сумма = 10, длина = 4
            assertEquals(4, subarray.getNum(listOf(1, 2, 3, 4), 10))
            assertEquals(4, subarrayOpt.getNum(listOf(1, 2, 3, 4), 10))
        }

        @Test
        fun allZeros() {
            // nums = [0, 0, 0, 0, 0], k = 0
            // Весь массив сумма = 0, длина = 5
            assertEquals(5, subarray.getNum(listOf(0, 0, 0, 0, 0), 0))
            assertEquals(5, subarrayOpt.getNum(listOf(0, 0, 0, 0, 0), 0))
        }

        @Test
        fun subarrayAtEnd() {
            // nums = [5, -2, -1, 4, 3], k = 6
            // Подмассив: [-1, 4, 3] сумма = 6, длина = 3
            assertEquals(4, subarray.getNum(listOf(5, -2, -1, 4, 3), 6))
            assertEquals(4, subarrayOpt.getNum(listOf(5, -2, -1, 4, 3), 6))
        }

        @Test
        fun negativeNumbers() {
            // nums = [-1, -1, 1, 1, 1], k = 1
            // Подмассив: [-1, 1, 1] сумма = 1, длина = 3
            assertEquals(5, subarray.getNum(listOf(-1, -1, 1, 1, 1), 1))
            assertEquals(5, subarrayOpt.getNum(listOf(-1, -1, 1, 1, 1), 1))
        }
    }

