package ru.butov.tasks

import java.util.LinkedList
import kotlin.test.Test
import kotlin.test.assertEquals

class MergeTwoListTest {

    @Test
    fun firstCase() {
        val list1 = LinkedList<Int>()
        list1.add(1)
        list1.add(2)
        list1.add(4)
        val list2 = LinkedList<Int>()
        list2.add(1)
        list2.add(3)
        list2.add(4)
        val mergeTwoList = MergeTwoList(list1, list2)
        val result = listOf(1,1,2,3,4,4)
        assertEquals(result,mergeTwoList.merge())
    }

    @Test
    fun secondCase() {
        val list1 = LinkedList<Int>()
        val list2 = LinkedList<Int>()
        val mergeTwoList = MergeTwoList(list1, list2)
        val result = listOf<Int>()
        assertEquals(result,mergeTwoList.merge())
    }
}