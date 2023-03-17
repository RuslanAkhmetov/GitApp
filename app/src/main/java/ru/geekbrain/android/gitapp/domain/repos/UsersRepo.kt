package ru.geekbrain.android.gitapp.domain.repos

import ru.geekbrain.android.gitapp.domain.entities.UserEntity


interface UsersRepo {
    //CRUD
    //Create(-)
    //Read

    fun getUsers(
        onSuccess: (List<UserEntity>) -> Unit,
        onError: ((Throwable) -> Unit)? = null
    )
    //Update(-)
    //Delete(-)



}