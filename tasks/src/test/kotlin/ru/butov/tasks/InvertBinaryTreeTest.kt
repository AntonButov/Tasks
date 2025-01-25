package ru.butov.tasks

import junit.framework.TestCase.assertEquals
import org.junit.Test

class InvertBinaryTreeTest {

    private val inputFirst
        get() = binaryTree(8) {
            left = binaryTree(5) {
                left = binaryTree(1)
                right = binaryTree(7)
            }
            right = binaryTree(10)
        }
    private val outputFirst
        get() = binaryTree(8) {
            right = binaryTree(5) {
                right = binaryTree(1)
                left = binaryTree(7)
            }
            left = binaryTree(10)
        }
    private val inputSecond
        get() = binaryTree(8) {
            left = binaryTree(5) {
                left = binaryTree(1)
                right = binaryTree(7)
            }
            right = binaryTree(10) {
                left = binaryTree(9)
                right = binaryTree(11)
            }
        }
    private val outputSecond
        get() = binaryTree(8) {
            right = binaryTree(5) {
                right = binaryTree(1)
                left = binaryTree(7)
            }
            left = binaryTree(10) {
                left = binaryTree(11)
                right = binaryTree(9)
            }
        }
    private val inputThird
        get() = binaryTree(8) {
            left = binaryTree(5) {
                left = binaryTree(1) {
                    left = binaryTree(12)
                    right = binaryTree(13)
                }
                right = binaryTree(7) {
                    left = binaryTree(14)
                    right = binaryTree(15)
                }
            }
            right = binaryTree(10) {
                left = binaryTree(9) {
                    left = binaryTree(16)
                    right = binaryTree(17)
                }
                right = binaryTree(11) {
                    left = binaryTree(18)
                    right = binaryTree(19)
                }
            }
        }
    private val outputThird
        get() = binaryTree(8) {
            right = binaryTree(5) {
                right = binaryTree(1) {
                    right = binaryTree(12)
                    left = binaryTree(13)
                }
                left = binaryTree(7) {
                    right = binaryTree(14)
                    left = binaryTree(15)
                }
            }
            left = binaryTree(10) {
                left = binaryTree(11) {
                    right = binaryTree(18)
                    left = binaryTree(19)
                }
                right = binaryTree(9) {
                    right = binaryTree(16)
                    left = binaryTree(17)
                }
            }
        }


    @Test
    fun recursiveFirst() {
        assertEquals(inputFirst.invertBinaryTreeRecursive(), outputFirst)
    }

    @Test
    fun stackFirst() {
        assertEquals(inputFirst.invertBinaryTreeLinkedList(true), outputFirst)
    }

    @Test
    fun queueFirst() {
        assertEquals(inputFirst.invertBinaryTreeLinkedList(false), outputFirst)
    }

    @Test
    fun recursiveSecond() {
        assertEquals(inputSecond.invertBinaryTreeRecursive(), outputSecond)
    }

    @Test
    fun stackSecond() {
        assertEquals(inputSecond.invertBinaryTreeLinkedList(true), outputSecond)
    }

    @Test
    fun queueSecond() {
        assertEquals(inputSecond.invertBinaryTreeLinkedList(false), outputSecond)
    }

    @Test
    fun recursiveThird() {
        assertEquals(inputThird.invertBinaryTreeRecursive(), outputThird)
    }

    @Test
    fun stackThird() {
        assertEquals(inputThird.invertBinaryTreeLinkedList(true), outputThird)
    }

    @Test
    fun queueThird() {
        assertEquals(inputThird.invertBinaryTreeLinkedList(false), outputThird)
    }

}

fun binaryTree(value: Int, block: (BinaryTree.() -> Unit)? = null): BinaryTree {
    return BinaryTree(value).apply {
        block?.invoke(this)
    }
}

