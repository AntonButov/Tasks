import java.util.LinkedList

interface ChangeCoin {
    fun getChainWfs(): Int
}

class ChangeCoinImpl(private val coins: List<Int>, private val amount: Int): ChangeCoin {

    private var result = 0
    private val queue = LinkedList<State>()
    override fun getChainWfs(): Int {
        getChainWfs(0, coins)
        return result
    }

    private fun getChainWfs(startValue: Int,coins: List<Int>) {
        queue.add(State(startValue, coins))
        do {
            val (startValueCurrent, coinsCurrent) = queue.removeFirst()
            if (coinsCurrent.size == 1) {
                val coinCurrent = coinsCurrent.first()
                if (startValueCurrent + coinCurrent < result) {
                    result = coinCurrent
                }
            } else {
                getChainWfs(startValue, coinsCurrent.subList(1, coinsCurrent.size))
            }
            coinsCurrent.getStates(startValueCurrent).forEach {
                queue.add(State(it, coins.subList(1, coins.size)))
            }
        println(queue)
        } while (queue.isNotEmpty())
    }

    fun List<Int>.getStates(startValueCurrent: Int): List<Int> {
        println(this)
        var current = 0
        return buildList {
            while (startValueCurrent + current < amount) {
                add(current)
                current += this@getStates.first()
            }
        }
    }

    data class State(
        val startValue: Int,
        val coins: List<Int>
    )
}