package ru.butov.tasks.dublicates

interface Duplicates {
    fun isDouble(input: List<Int>): Boolean
}

class DuplicatesImpl() : Duplicates {
    override fun isDouble(input: List<Int>): Boolean {
        val set = input.toSet()
        return input.size != set.size
    }

}