package ru.butov.tasks.path_in_matrics_whose_sum_Is_divisible_by_k

// 7 3 4 9
// 2 3 6 2
// 2 3 7 0
fun List<List<Int>>.numberOfPaths(k: Int): Int =
    numberOfPath(0, 0, 0, k)

private tailrec fun List<List<Int>>.numberOfPath(sum: Int, x: Int, y: Int, k: Int): Int {
    val xMax = this[0].size - 1
    val yMax = this.size - 1
    val element = this[y][x]
    val newSum = sum + element
    if (x == xMax && y == yMax) return checkDivisibleByK(newSum, k)
    val numberX = if (x < xMax) numberOfPath(newSum, x + 1, y, k)
    else 0
    val numberY = if (y < yMax) numberOfPath(newSum, x, y + 1, k)
    else 0
    return numberX + numberY
}

private fun checkDivisibleByK(newSum: Int, k: Int) =
    if (newSum % k == 0) 1
    else 0
