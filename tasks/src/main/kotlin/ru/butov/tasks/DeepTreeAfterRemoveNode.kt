package ru.butov.tasks

import kotlin.math.max

    fun Node.treeQueries(removeArray: List<Int>): List<Int> =
        removeArray.map {
            treeQueries(0, it)
        }

    private fun Node.treeQueries(level: Int, removeValue: Int): Int {
        val leftLevel = left?.let {
            if (it.value == removeValue) 0
            else it.treeQueries(level + 1, removeValue)
        } ?: 0
        val rightLevel = right?.let {
            if (it.value == removeValue) 0
            else it.treeQueries(level + 1, removeValue)
        } ?: 0
        return max(level, max(leftLevel, rightLevel))
    }

data class Node(
    val value: Int,
    val left: Node? = null,
    val right: Node? = null
)