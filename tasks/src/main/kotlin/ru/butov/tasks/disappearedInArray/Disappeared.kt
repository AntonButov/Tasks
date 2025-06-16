package ru.butov.tasks.disappearedInArray

interface Disappeared {
    fun getDisappeared(input: List<Int>): List<Int>
}

class DisappearedImpl : Disappeared {
    override fun getDisappeared(input: List<Int>): List<Int> {
        val set = mutableSetOf<Int>()
        input.forEach {
            set.add(it)
        }
        val result = mutableListOf<Int>()
        (1..input.size).forEach {
            if (!set.contains(it)) {
                result.add(it)
            }
        }
        return result
    }
}