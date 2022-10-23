package com.example.tasks2

class MajorityElement {

    class AccumulatedResult {


        private val result = mutableSetOf<Int>()

        private lateinit var source: List<Int>

        fun map(element: Int) {
            val count = source.filter { it == element }.count()
            if (count > source.count()/3)
                result.add(element)
        }

        fun toResult() = result.toList()


        companion object {
            fun createDefault(source: List<Int>) =
                AccumulatedResult().apply {
                    this.source = source
                }

        }
    }

    fun getMajor(nums: List<Int>): List<Int> =
        nums.fold(AccumulatedResult.createDefault(nums)) { acc, element ->
           acc.apply {  map(element) }
        }.toResult()

}