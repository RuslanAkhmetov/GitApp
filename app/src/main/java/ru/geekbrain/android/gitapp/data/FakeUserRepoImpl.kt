package ru.geekbrain.android.gitapp.data

import android.os.Handler
import android.os.Looper
import ru.geekbrain.android.gitapp.domain.entities.UserEntity
import ru.geekbrain.android.gitapp.domain.repos.UsersRepo

private const val DATA_LOADING_FAKE_DELLAY = 1000L

class FakeUserRepoImpl : UsersRepo {
    private val userList = listOf<UserEntity>(
        UserEntity("mojombo", 1,  "https://avatars.githubusercontent.com/u/1?v=4"),
        UserEntity("defunkt", 2, "https://avatars.githubusercontent.com/u/2?v=4"),
        UserEntity("pjhyett", 3, "https://avatars.githubusercontent.com/u/3?v=4"),
        UserEntity("wycats", 4, "https://avatars.githubusercontent.com/u/4?v=4")
    )



    override fun getUsers(onSuccess: (List<UserEntity>) -> Unit, onError: ((Throwable) -> Unit)?) {
        Handler(Looper.getMainLooper()).postDelayed( {
            onSuccess(userList)
        }, DATA_LOADING_FAKE_DELLAY)

    }
}