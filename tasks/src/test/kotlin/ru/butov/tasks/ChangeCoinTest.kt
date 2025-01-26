package ru.butov.tasks

import ChangeCoinDp
import org.junit.Assert
import org.junit.Test

class ChangeCoinTest {

    @Test
    fun firstCase() {
        val coins =  listOf(1, 2, 5)
        val amount = 11
        val output = 3
        Assert.assertEquals(output, ChangeCoinDp().coinChange(coins.toIntArray(), amount))
        //Assert.assertEquals(output, ChangeCoinImpl(coins, amount).getChainWfs())
    }
}