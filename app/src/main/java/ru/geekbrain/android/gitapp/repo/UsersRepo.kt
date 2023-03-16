package ru.geekbrain.android.gitapp.repo

import ru.geekbrain.android.gitapp.remote.UserEntity

interface UsersRepo {
    //CRUD
    //Create(-)
    //Read
    fun getUsersSync():List<UserEntity>     //синхронный
    fun getUsers(
        onSuccess: (List<UserEntity>) -> Unit,
        onError: ((Throwable) -> Unit)? = null
    )
    //Update(-)
    //Delete(-)



}