package ru.butov.tasks

import java.util.LinkedList

class Parentheses {

    private val parenthesesPairs = mapOf('(' to ')', '[' to ']', '{' to '}')

    fun check(input: String): Boolean {
        val deque: LinkedList<Char> = LinkedList()
        input.forEach {
            val last = deque.getLastOrNull()
            if (it == parenthesesPairs[last]) {
                deque.removeLast()
            } else {
                deque.add(it)
            }
        }
        return deque.isEmpty()
    }

    private fun LinkedList<Char>.getLastOrNull(): Char? {
        if (isEmpty()) return null
        return last
    }

    fun checkChatGpt(input: String): Boolean {
        val stack = LinkedList<Char>()

        for (char in input) {
            if (char in parenthesesPairs.keys) {
                stack.push(char) // Открывающая скобка → кладём в стек
            } else {
                if (stack.isEmpty() || parenthesesPairs[stack.pop()] != char) {
                    return false // Стек пуст или скобка не закрывается правильно
                }
            }
        }
        return stack.isEmpty() // Должны закрыться все скобки
    }
}