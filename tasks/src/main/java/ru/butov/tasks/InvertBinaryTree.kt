package ru.butov.tasks

import java.util.LinkedList

data class BinaryTree(
    var value: Int = 0,
    var left: BinaryTree? = null,
    var right: BinaryTree? = null
) {
    override fun toString(): String {
        return value.toString()
    }
}

fun BinaryTree.invertBinaryTreeRecursive(): BinaryTree {
    val oldLeft = left
    left = right
    right = oldLeft

    left?.invertBinaryTreeRecursive()
    right?.invertBinaryTreeRecursive()
    return this
}

fun BinaryTree.invertBinaryTreeLinkedList(first: Boolean): BinaryTree {
    val list = LinkedList<BinaryTree>()
    list.add(this)
    println("add ${this.value}")
    while (list.isNotEmpty()) {
        println(list)
        val node = if (first) list.removeFirst()
        else list.removeLast()
        println("remove ${node.value}")
        node.left?.let {
            list.add(it)
            println("add ${it.value}")
        }
        node.right?.let {
            list.add(it)
            println("add ${it.value}")
        }
        val oldLeft = node.left
        node.left = node.right
        node.right = oldLeft
    }
    return this
}


