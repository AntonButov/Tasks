package ru.butov.tasks

import java.util.LinkedList

class UniquePaths(
    private val m: Int,
    private val n: Int) {

    fun breadFirstSearch(): Int  {
        val queue = LinkedList<Pair<Int, Int>>()
        var result = 1
        queue.addLast(1 to 1)
        while (queue.isNotEmpty()) {
            val (mCurrent, nCurrent) = queue.removeFirst()
            if (isCanRight(mCurrent)) {
                queue.addLast(mCurrent + 1  to nCurrent)
            }
            if (isCanBottom(nCurrent)) {
                queue.addLast(mCurrent to nCurrent + 1)
            }
            if (hasNewWay(mCurrent, nCurrent)) {
                result++
            }
        }
        return result
    }

    fun deepFirstSearch(): Int {
        val queue = LinkedList<Pair<Int, Int>>()
        var result = 1
        queue.addLast(1 to 1)
        while (queue.isNotEmpty()) {
            val (mCurrent, nCurrent) = queue.removeLast()
            if (isCanRight(mCurrent)) {
                queue.addLast(mCurrent + 1  to nCurrent)
            }
            if (isCanBottom(nCurrent)) {
                queue.addLast(mCurrent to nCurrent + 1)
            }
            if (hasNewWay(mCurrent, nCurrent)) {
                result++
            }
        }
        return result
    }

    private fun hasNewWay(mCurrent: Int, nCurrent: Int) = isCanRight(mCurrent) && isCanBottom(nCurrent)

    private fun isCanRight(mCurrent: Int) = mCurrent < m

    private fun isCanBottom(nCurrent: Int) = nCurrent < n
}