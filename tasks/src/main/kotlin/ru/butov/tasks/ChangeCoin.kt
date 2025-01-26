import java.util.LinkedList

interface ChangeCoin {
    fun getChainWfs(): Int
}

class ChangeCoinImpl(private val coins: List<Int>, private val amount: Int): ChangeCoin {
    override fun getChainWfs(): Int {
        var result = 0
        val queue = LinkedList<State>()
        queue.add(State(0, coins))
        do {
            val (startValueCurrent, coinsCurrent) = queue.removeFirst()
            if (coinsCurrent.size == 1) {
                val coinCurrent = coinsCurrent.first()
                if (startValueCurrent + coinCurrent < result) {
                    result = coinCurrent
                }
                continue
            }
            coinsCurrent.getStats(startValueCurrent).forEach {
                queue.add(State(it, coins.subList(1, coins.size)))
            }
        println(queue)
        } while (queue.isNotEmpty())
        return result
    }

    fun List<Int>.getStats(startValueCurrent: Int): List<Int> {
        println(this)
        var current = 0
        return buildList {
            while (startValueCurrent + current < amount) {
                add(current)
                current += this@getStats.first()
            }
        }
    }

    data class State(
        val startValue: Int,
        val coins: List<Int>
    )
}