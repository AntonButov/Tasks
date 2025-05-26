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

class IndexOfCacheImpl : IndexOf {
    override fun getIndex(source: String, target: String): Int {
        if (source.length < target.length) return -1
        if (target.isEmpty()) return 0
        val targetCache = initCache(target)
        var currentCache = initCache(source.take(target.length))
        val lastI = source.length - target.length
        (0..lastI).forEach {
            if (it != 0) {
                currentCache = currentCache - source[it - 1].hashCode() + source[it + target.length - 1].hashCode()
            }
            if (currentCache == targetCache && source.substring(it, it +target.length) == target) return it
        }
        return  -1
    }

    private fun initCache(str: String): Int {
        return str.fold(0) { current, char -> current + char.hashCode() }
    }

}