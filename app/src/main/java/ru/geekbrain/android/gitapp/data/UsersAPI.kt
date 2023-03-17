package ru.geekbrain.android.gitapp.data

import retrofit2.Call
import retrofit2.http.GET
import ru.geekbrain.android.gitapp.domain.entities.UserEntity

private const val GIT_HUB_USERS = "users"

interface UsersAPI {

    @GET(GIT_HUB_USERS)
    fun getUsers() : Call<ArrayList<UserEntity>>

}
