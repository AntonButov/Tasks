package ru.butov.tasks.longestCommonPrefix

class LongestCommonPrefix {

    fun getLongestImperative(source: List<String>): String {
        val firstString = source.first()
        var result = ""
        firstString.indices.forEach { charIndex ->
            (1 until source.count()).forEach { listIndex ->
                if (charIndex > source[listIndex].length ||
                    firstString[charIndex] != source[listIndex][charIndex]) return result
            }
            result += firstString[charIndex]
        }
        return result
    }

}