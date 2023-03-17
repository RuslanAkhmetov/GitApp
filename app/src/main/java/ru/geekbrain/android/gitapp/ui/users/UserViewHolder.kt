package ru.geekbrain.android.gitapp.ui.users

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import ru.geekbrain.android.gitapp.R
import ru.geekbrain.android.gitapp.databinding.ItemUserBinding
import ru.geekbrain.android.gitapp.domain.entities.UserEntity

class UserViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
) {
    private val binding = ItemUserBinding.bind(itemView)

    fun bind(userEntity: UserEntity){
        binding.avatarImageView.load(userEntity.avatarUrl)
        binding.loginTextView.text = userEntity.login
        binding.idTextView.text = userEntity.id.toString()
    }
}