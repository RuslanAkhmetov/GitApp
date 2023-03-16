package ru.geekbrain.android.gitapp.ui.users

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.geekbrain.android.gitapp.domain.UserEntity

class UsersAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private val usersList = mutableListOf<UserEntity>()

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int) = getItem(position).id

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(parent)


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemCount() = usersList.size

    private fun getItem(pos:Int) =  usersList[pos]


    @SuppressLint("NotifyDataSetChanged")
    fun setDate(users: List<UserEntity>){
        usersList.clear()
        usersList.addAll(users)
        notifyDataSetChanged()
    }

}