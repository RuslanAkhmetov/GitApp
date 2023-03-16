package ru.geekbrain.android.gitapp.domain


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