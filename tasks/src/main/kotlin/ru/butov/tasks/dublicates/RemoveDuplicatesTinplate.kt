package ru.butov.tasks.dublicates

interface RemoveKInPlace {
    fun removeDuplicates(input: IntArray, k: Int): IntArray
}

class RemoveInPlaceImpl : RemoveKInPlace {
    override fun removeDuplicates(input: IntArray, k: Int): IntArray {
       var i = 0
       var newI = 0
       while (i + newI < input.size) {
            if (input[i + newI] == k) {
                newI ++
                continue
            }
           input[i] = input[i + newI]
           i ++
       }
        return input
    }
}