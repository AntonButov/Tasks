package ru.butov.tasks.dublicates

interface RemoveDuplicatesFromSortedArrayInterface {
    fun String.removeDuplicates(): String
}

class RemoveDuplicatesFromSortedArray: RemoveDuplicatesFromSortedArrayInterface {
    override fun String.removeDuplicates(): String {
        val inputString = this
        return buildString {
            inputString.forEach {
                if (lastOrNull() != it) {
                    append(it)
                }
            }
        }
    }

}