package ru.butov.tasks

interface Initials {
    fun initials(name: String): String
}

class InitialsImpl() : Initials {
    override fun initials(name: String): String {
        val result = name
            .trim()
            .split(" ")
            .map {
                it.first().toString().uppercase()
            }.joinToString("")

        if (result.length == 3) {
            return result[0].toString() + result[2].toString()
        }
        return result
    }
}

interface Rounded {
    fun round(amount: Double): Double
}

class RoundedImpl : Rounded {
    override fun round(amount: Double): Double {
        val result = (amount / 13) * 5
        val roundedResult = kotlin.math.round(result * 10000) / 10000
        return roundedResult
    }
}
