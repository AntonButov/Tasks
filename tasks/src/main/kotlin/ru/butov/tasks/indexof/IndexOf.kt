package ru.butov.tasks.indexof

interface IndexOf {
    fun getIndex(source: String, target: String): Int
}

class IndexOfImpl : IndexOf {

    override fun getIndex(source: String, target: String): Int {
        (0 .. source.length - target.length).forEach { inx ->
             if (source.substring(inx .. inx + target.length - 1) == target) {
                 return inx
             }
        }
        return -1
    }

}