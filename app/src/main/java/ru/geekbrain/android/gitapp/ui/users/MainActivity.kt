package ru.geekbrain.android.gitapp.ui.users

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import ru.geekbrain.android.gitapp.app
import ru.geekbrain.android.gitapp.databinding.ActivityMainBinding
import ru.geekbrain.android.gitapp.domain.UserEntity
import ru.geekbrain.android.gitapp.domain.UsersRepo

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = UsersAdapter()

    private val userRepo: UsersRepo by lazy { app.UsersRepo }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        showProgress(false)
        binding.refreshButton.setOnClickListener {
            loadData()
        }
        initRecyclerView()
    }

    private fun loadData(){
        showProgress(true)
        userRepo.getUsers(
            onSuccess = { //                    adapter::setDate,   //передаем метод в лямду onSuccess сигнатура должна совпадать
                showProgress(false)
                onDataLoaded(it)
            },
            onError = {
                showProgress(false)
                onError(it)
            }
        )
    }

    private fun onDataLoaded(listUser: List<UserEntity>) {
        adapter.setDate(listUser)
    }

    private fun onError(throwable: Throwable){
        Toast.makeText(this, throwable.message, Toast.LENGTH_SHORT).show()
    }

    private fun initRecyclerView() {
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.usersRecyclerView.adapter = adapter

    }

    private fun showProgress(inProgress: Boolean) {
        binding.progressCircular.isVisible = inProgress
        binding.usersRecyclerView.isVisible = !inProgress

    }
}