import kotlin.test.Test

class MutabilityIdentifyProblem {

    @Test
    fun identifyProblem() {
        data class MutableKey(val id: Int, var isEnabled: Boolean)

        val mutableKey = MutableKey(1, true)
        val mutableKeySecond = MutableKey(2, true)
        val storage = mapOf(
            mutableKey to "I am data.",
            mutableKeySecond to "I am data too."
        )
        mutableKey.isEnabled = false

        println(storage[mutableKey]) // null
    }

}