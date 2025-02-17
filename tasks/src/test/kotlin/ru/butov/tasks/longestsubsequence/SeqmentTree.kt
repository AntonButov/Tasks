package ru.butov.tasks.longestsubsequence

import kotlin.math.max

class SegmentTree(N: Int) {
    var n: Int = N
    var tree: IntArray

    init {
        while ((n and (n - 1)) != 0) {
            n++
        }
        tree = IntArray(2 * n)
    }

    fun update(i: Int, value: Int) {
        tree[n + i] = value
        var j = (n + i) / 2
        while (j >= 1) {
            tree[j] = max(tree[j * 2], tree[j * 2 + 1])
            j /= 2
        }
    }

    fun query(l: Int, r: Int): Int {
        if (l > r) return 0
        var res = Int.MIN_VALUE
        var left = l + n
        var right = r + n + 1
        while (left < right) {
            if (left and 1 != 0) {
                res = max(res, tree[left])
                left++
            }
            if (right and 1 != 0) {
                right--
                res = max(res, tree[right])
            }
            left /= 2
            right /= 2
        }
        return res
    }
}

class LongestSubstringTree {

    fun lengthOfLIS(nums: IntArray): Int {
        val compressedNums = compress(nums)
        val n = compressedNums.size
        val segTree = SegmentTree(n)
        var LIS = 0
        for (num in compressedNums) {
            val curLIS = segTree.query(0, num - 1) + 1
            segTree.update(num, curLIS)
            LIS = max(LIS, curLIS)
        }
        return LIS
    }

    private fun compress(arr: IntArray): IntArray {
        val sortedArr = arr.toSortedSet().toIntArray()
        return arr.map { sortedArr.binarySearch(it) }.toIntArray()
    }
}