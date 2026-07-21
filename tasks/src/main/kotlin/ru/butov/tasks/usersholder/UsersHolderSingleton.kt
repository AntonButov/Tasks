package ru.butov.tasks.usersholder

import java.util.LinkedList
import java.util.concurrent.Executors

object Const {
    val INDEX = 1
}

private const val TAG = "ClassTag"

class UserData(
    val id: Int,
    val name: String,
    val phoneNumber: String,
)

interface Repository {
    fun get(): LinkedList<UserData>
}

open class UsersHolderSingleton private constructor(
    val context: Context,
    val usersRepo: Repository,
) : LoggerProvider() {

    companion object {
        @Volatile
        private var instance: UsersHolderSingleton? = null

        fun getInstance(context: Context, usersRepo: Repository): UsersHolderSingleton {
            if (instance == null) {
                instance = UsersHolderSingleton(context, usersRepo)
            }
            return instance!!
        }

        fun clearInstance() {
            instance = null
        }
    }

    var users: LinkedList<UserData> = LinkedList()
        get() = usersRepo.get()

    val executor = Executors.newFixedThreadPool(5)

    fun update(id: Int, newPhone: String) {
        val phoneNumber = context.getString(R.string.formatted_phonem, newPhone)
        val copy = { user: UserData ->
            UserData(
                user.id,
                user.name,
                phoneNumber,
            )
        }
        for (i in Const.INDEX until users.size) {
            if (users[i].id == id) {
                users[i] = copy(users[i])
                logger.tag(TAG).d(users[i])
            }
        }
    }
}
