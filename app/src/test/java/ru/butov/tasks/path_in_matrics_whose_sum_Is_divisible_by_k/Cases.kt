package ru.butov.tasks.path_in_matrics_whose_sum_Is_divisible_by_k

data class TestCase(
    val input: List<List<Int>>,
    val k: Int,
    val numberOfPath: Int
)

val caseZero = TestCase(
    input = listOf(
        listOf(2, 1),
        listOf(1, 0),
    ),
    k = 3,
    numberOfPath = 2
)

val caseFirst = TestCase(
    input = listOf(
        listOf(5, 2, 4), // 2,      2,      1
                         // [0,0,1] [0,1,0] [0,0,1]
        listOf(3, 0, 5), // 0,      0,      2
                         // [0,0,1] [0,1,1] [0,1,2]+[2]=[1,2,0]
        listOf(0, 7, 2)  // 0,      1,      2
                         //[0,0,1] [2,0,2] [2,0,0]
    ),
    k = 3,
    numberOfPath = 2
)

val caseSecond = TestCase(
    input = listOf(
        listOf(0, 0)
    ),
    k = 5,
    numberOfPath = 1
)

val caseThird = TestCase(
    input = listOf(
        listOf(7, 3, 4, 9),
        listOf(2, 3, 6, 2),
        listOf(2, 3, 7, 0),
    ),
    k = 1,
    numberOfPath = 10
)