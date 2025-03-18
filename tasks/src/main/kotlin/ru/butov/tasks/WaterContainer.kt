package ru.butov.tasks

import kotlin.math.min

interface WaterContainer {
    fun getMaxWater(input: List<Int>): Int
}

class WaterContainerImpl: WaterContainer {
    override fun getMaxWater(input: List<Int>): Int {
        var maxWater = 0
        var left = 0
        var right = input.size - 1
        while (left < right) {
            maxWater = kotlin.math.max(maxWater, kotlin.math.min(input[left], input[right]) * (right - left))
            if (input[left] < input[right]) {
                left++
            } else {
                right--
            }
        }
        return maxWater
    }
}
/* // my solution wrong and ineffective
class WaterContainerImp : WaterContainer {
    private val dp = mutableListOf<Chunk>()
    private var maxS = 0
    override fun getMaxWater(input: List<Int>): Int {
        dp.addLast(input.first(), 0)
        (1 until input.size).forEach { n ->
            val h = input[n]
            val chunk = dp.getChunkByH(h)
            val s = (n - chunk.n) * min(h, chunk.h)
            maxS = maxOf(maxS, s)
            if (dp.last().h < h) {
                dp.addLast(h, n)
            }
        }
        return maxS
    }

    private fun List<Chunk>.getChunkByH(h: Int): Chunk {
        val index = binarySearchBy(h) { it.h }
        if (index < 0) {
            return last()
        }
        return this[index]
    }

    private fun MutableList<Chunk>.addLast(h: Int, n: Int) = this.add(Chunk(h, n))

    data class Chunk(
        val h: Int,
        val n: Int
    )

}
*/