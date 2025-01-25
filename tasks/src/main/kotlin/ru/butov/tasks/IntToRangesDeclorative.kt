package com.example.tasks2

class IntToRangesDeclorative {

    class AccumulatedResult {

        private val result = mutableListOf<Pair<Int,Int>>()

        private lateinit var currentRange: Pair<Int,Int>

        fun openRange(startRange: Int) {
            currentRange = startRange to startRange
        }

        fun extendRange(endRange: Int) {
            currentRange = currentRangeStart to endRange
        }


        fun closeRange() {
            result.add(currentRange)
        }

        val currentRangeStart: Int
        get() = currentRange.first

        val currentRangeLast: Int
        get() = currentRange.second

        fun inCurrentRange(element: Int) =
            element in currentRangeStart .. currentRangeLast

        fun toResult(): List<String> {
            closeRange()
            return result.map { element ->
            if (element.first < element.second)
                    "${element.first}->${element.second}"
                else
                    "${element.first}"
            }
        }


        companion object {
            fun createDefault(startRange: Int) =
                AccumulatedResult().apply {
                    openRange(startRange)
                }

        }



    }

    fun summaryRanges(nums: List<Int>): List<String> =
        nums.foldIndexed(AccumulatedResult.createDefault(nums.first())) {index, acc, element ->
            if (index == 0) return@foldIndexed acc
            if (acc.inCurrentRange(element - 1)) acc.also {
                it.extendRange(element)
            }
            else acc.also {
                it.closeRange()
                it.openRange(element)
            }
        }.toResult()

}