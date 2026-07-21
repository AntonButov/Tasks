package ru.butov.tasks.usersholder

/**
 * JVM stubs that stand in for Android types.
 * In a real project these come from the Android SDK.
 */
class Context {
    fun getString(resId: Int, vararg formatArgs: Any): String {
        val template = stringResources[resId] ?: "%s"
        return String.format(template, *formatArgs)
    }

    companion object {
        private val stringResources = mutableMapOf<Int, String>()

        fun putStringResource(resId: Int, value: String) {
            stringResources[resId] = value
        }

        fun clearStringResources() {
            stringResources.clear()
        }
    }
}

object R {
    object string {
        const val formatted_phonem = 1
    }
}

interface Logger {
    fun tag(tag: String): Logger
    fun d(message: Any?)
}

open class LoggerProvider {
    protected val logger: Logger = object : Logger {
        private var currentTag: String = ""

        override fun tag(tag: String): Logger {
            currentTag = tag
            return this
        }

        override fun d(message: Any?) {
            println("D/$currentTag: $message")
        }
    }
}
