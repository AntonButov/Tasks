package ru.butov.tasks.prioritymatrix

interface PriorityMatrix {
    fun getNumber(input: List<List<Int>>, k: Int): Int
}

class PriorityMatrixIntervals: PriorityMatrix {
    val queue = java.util.PriorityQueue<Int>()
    var currentK = 1
    var current = 0
    var h = 0
    override fun getNumber(input: List<List<Int>>, k: Int): Int {
        queue.addAll(input[0])
        while (currentK <= k) {
            current = queue.poll()
            ++currentK
            if (h == input.size - 1) {
                continue
            }
            if (queue.isEmpty()) {
                loadNext(input)
                continue
            }
            val next = queue.peek()
            if (next > input[h + 1][0]) {
                loadNext(input)
            }
        }
        return current
    }

    private fun loadNext(input: List<List<Int>>) {
        ++h
        queue.addAll(input[h])
    }


}