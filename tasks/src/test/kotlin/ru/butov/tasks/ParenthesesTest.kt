package ru.butov.tasks

import org.junit.Assert
import org.junit.Test

class ParenthesesTest {

    @Test
    fun firstCase() {
        val input = "()"
        val parentheses = Parentheses()
        assert(parentheses.check(input))
        assert(parentheses.checkChatGpt(input))
    }

    @Test
    fun secondCase() { // todo
        val input = "()[]{}"
        val parentheses = Parentheses()
       // assert(parentheses.check(input)) todo
        assert(parentheses.checkChatGpt(input))
    }

    @Test
    fun thirdCase() {
        val input = "{[]}"
        val parentheses = Parentheses()
        assert(parentheses.check(input))
        assert(parentheses.checkChatGpt(input))
    }

    @Test
    fun forthCase() {
        val input = "([)]"
        val parentheses = Parentheses()
        Assert.assertFalse(parentheses.check(input))
        Assert.assertFalse(parentheses.checkChatGpt(input))
    }

    @Test
    fun fiveCase() {
        val input = "([)]"
        val parentheses = Parentheses()
        Assert.assertFalse(parentheses.check(input))
        Assert.assertFalse(parentheses.checkChatGpt(input))
    }
}