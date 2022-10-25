package ru.butov.tasks

class ThreeSum {

    class AccInner(
        private val first: Int
    ) {

        private val result = mutableListOf<List<Int>>()

        fun add(element: Int) {
            result.add(
                listOf(first, element)
            )
        }

        fun getResult() =
            result.toList()

        companion object {
            fun create(first: Int) =
                AccInner(first)
        }

    }

    class Acc(private val first: Int) {

        private val accList: MutableList<List<Int>> = mutableListOf()

        fun add(list: List<Int>) {
            if (list.size < 3) return
            val sublist = list.slice(1..list.lastIndex)

            sublist.fold(AccInner.create(list.first())) { accInner, element ->
                accInner.add(element)
                accInner
            }
                .getResult()
                .map {
                    buildList {
                        add(first)
                        addAll(it)
                    }
                }.also {
                    accList.addAll(it)
                }
        }

        fun getResult(): List<List<Int>> =
            accList.toList()


        companion object {
            fun createDefault(first: Int) =
                Acc(first)
        }
    }

    fun find(source: List<Int>): List<List<Int>> =
        source.foldIndexed(Acc.createDefault(source.first())) { index, acc, element ->
            acc.add(source.slice(index + 1 until source.size))
            acc
        }
            .getResult()
            .filter { it.sum() == 0 }

}