package ru.butov.tasks.usersholder

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.util.LinkedList
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertSame
import kotlin.test.assertTrue

class UsersHolderSingletonTest {

    private lateinit var context: Context
    private lateinit var users: LinkedList<UserData>
    private lateinit var repository: Repository

    @Before
    fun setUp() {
        UsersHolderSingleton.clearInstance()
        Context.clearStringResources()
        Context.putStringResource(R.string.formatted_phonem, "+%s")

        context = Context()
        users = LinkedList(
            listOf(
                UserData(id = 0, name = "Header", phoneNumber = "000"),
                UserData(id = 1, name = "Alice", phoneNumber = "111"),
                UserData(id = 2, name = "Bob", phoneNumber = "222"),
            ),
        )
        repository = object : Repository {
            override fun get(): LinkedList<UserData> = users
        }
    }

    @After
    fun tearDown() {
        UsersHolderSingleton.clearInstance()
        Context.clearStringResources()
    }

    @Test
    fun getInstance_returnsSameSingleton() {
        val first = UsersHolderSingleton.getInstance(context, repository)
        val second = UsersHolderSingleton.getInstance(context, repository)

        assertNotNull(first)
        assertSame(first, second)
    }

    @Test
    fun users_delegatesToRepository() {
        val holder = UsersHolderSingleton.getInstance(context, repository)

        assertEquals(3, holder.users.size)
        assertEquals("Alice", holder.users[1].name)
    }

    @Test
    fun update_changesPhoneForMatchingIdFromIndex() {
        val holder = UsersHolderSingleton.getInstance(context, repository)

        holder.update(id = 2, newPhone = "999")

        assertEquals("+999", holder.users[2].phoneNumber)
        assertEquals("Bob", holder.users[2].name)
    }

    @Test
    fun update_skipsUserAtIndexZero() {
        val holder = UsersHolderSingleton.getInstance(context, repository)

        holder.update(id = 0, newPhone = "555")

        assertEquals("000", holder.users[0].phoneNumber)
    }

    @Test
    fun update_doesNothingWhenIdNotFound() {
        val holder = UsersHolderSingleton.getInstance(context, repository)
        val before = holder.users.map { it.phoneNumber }

        holder.update(id = 99, newPhone = "000")

        assertEquals(before, holder.users.map { it.phoneNumber })
    }

    @Test
    fun executor_isCreated() {
        val holder = UsersHolderSingleton.getInstance(context, repository)

        assertTrue(holder.executor.isShutdown.not())
        holder.executor.shutdown()
    }
}
