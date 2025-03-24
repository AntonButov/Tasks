import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import ru.butov.tasks.ProductArrayExceptSelfImpl
import kotlin.test.Test

class ProductExceptSelfTest {

    private val productArrayExceptSelf = ProductArrayExceptSelfImpl()

    @Test
    fun `basic case with positive numbers`() {
        val nums = listOf(1, 2, 3, 4)
        val expected = listOf(24, 12, 8, 6)
        assertEquals(expected, productArrayExceptSelf.product(nums))
    }

    @Test
    fun `case with zeros`() {
        val nums = listOf(-1, 1, 0, -3, 3)
        val expected = listOf(0, 0, 9, 0, 0)
        assertEquals(expected, productArrayExceptSelf.product(nums))
    }

    @Test
    fun `case with all ones`() {
        val nums = listOf(1, 1, 1, 1)
        val expected = listOf(1, 1, 1, 1)
        assertEquals(expected, productArrayExceptSelf.product(nums))
    }

    @Test
    fun `case with two elements`() {
        val nums = listOf(2, 3)
        val expected = listOf(3, 2)
        assertEquals(expected, productArrayExceptSelf.product(nums))
    }

    @Test
    fun `case with negative numbers`() {
        val nums = listOf(-1, -2, -3, -4)
        val expected = listOf(-24, -12, -8, -6)
        assertEquals(expected, productArrayExceptSelf.product(nums))
    }
}
