package ru.butov.tasks

class SnackBack {
    fun getCount(weights: List<Int>, W: Int): Int {
        val n = weights.size
        val dp: MutableList<MutableList<Int>> = MutableList(n + 1) { MutableList(W + 1) { 0 } }

        for (i in 1..n) {
            for (w in 0..W) {
                dp[i][w] = dp[i - 1][w]
                if (w >= weights[i - 1]) {
                    dp[i][w] = maxOf(dp[i][w], dp[i - 1][w - weights[i - 1]] + 1)
                }
            }
            println(dp)
        }
        return dp[n][W]
    }

    fun getCountWithRepeat(weights: List<Int>, W: Int): Int {
        val dp: MutableList<Int> = MutableList(W + 1 ) { 0 }
        dp[0] = 0
        for (w in 1 ..W) {
            println(dp)
            for (weight in weights) {
                if (w >= weight) {
                    dp[w] = maxOf(dp[w], dp[w - weight] + 1)
                }
            }
        }
        println(dp)
        return dp[W]
    }

}