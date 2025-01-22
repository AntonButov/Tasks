package ru.butov.tasks

import org.junit.Test
import org.junit.Assert.*
import ru.butov.tasks.height_of_binary_tree_after_subtree_removal_queries.Node
import ru.butov.tasks.height_of_binary_tree_after_subtree_removal_queries.treeQueries

class DeepTreeAfterRemoveNodeUnitTest {

    //     1
    //    / \
    //   2   3
    //  / \   \
    // 4   5   6
    //          \
    //           7
    // removeArray = [2,3,7]
    // result = [3,2,2]

    @Test
    fun firstCase() {
        val root = Node(
            value = 1,
            left = Node(
                value = 2,
                left = Node(value = 4),
                right = Node(value = 5)
            ),
            right = Node(
                value = 3,
                right = Node(
                    value = 6,
                    right = Node(value = 7)
                )
            )
        )
        val removeArray = listOf(2, 3, 7)
        val expected = listOf(3, 2, 2)
        val testResult = root.treeQueries(removeArray)
        assertEquals(testResult, expected)
    }

    //         5
    //      /    \
    //     8      9
    //    / \    / \
    //   2   1  3   7
    //  / \
    // 4   6
    //
    //

    @Test
    fun secondCase() {
        val root = Node(
            value = 5,
            left = Node(
                value = 8,
                left = Node(
                    value = 2,
                    left = Node(value = 4),
                    right = Node(6)
                ),
                right = Node(1)
            ),
            right = Node(
                value = 9,
                left = Node(3),
                right = Node(7)
            )
        )
        val removeArray = listOf(3, 2, 4, 8)
        val expected = listOf(3, 2, 3, 2)
        val testResult = root.treeQueries(removeArray)
        assertEquals(testResult, expected)
    }

    //        1
    //      /  \
    //     3    4
    //    /    / \
    //   2    6   5
    //             \
    //              7

    @Test
    fun threeCase() {
        val root = Node(
            value = 1,
            left = Node(
                value = 3,
                left = Node(value = 2)
            ),
            right = Node(
                value = 4,
                left = Node(6),
                right = Node(
                    value = 5,
                    right = Node(7)
                )
            )
        )
        val removeArray = listOf(4)
        val expected = listOf(2)
        val testResult = root.treeQueries(removeArray)
        assertEquals(testResult, expected)
    }
}