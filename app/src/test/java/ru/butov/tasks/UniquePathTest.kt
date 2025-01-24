import org.junit.Assert
import org.junit.Test
import ru.butov.tasks.UniquePaths

class UniquePathTest {

    @Test
    fun firstCade() {
        val uniquePaths = UniquePaths(3, 2)

        Assert.assertEquals(3, uniquePaths.breadFirstSearch())
        Assert.assertEquals(3, uniquePaths.deepFirstSearch())
    }

    @Test
    fun secondCade() {
        val uniquePaths = UniquePaths(3, 7)

        Assert.assertEquals(28, uniquePaths.breadFirstSearch())
        Assert.assertEquals(28, uniquePaths.breadFirstSearch())
    }
}