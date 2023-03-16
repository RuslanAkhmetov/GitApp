package ru.geekbrain.android.gitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ru.geekbrain.android.gitapp.databinding.ActivityMainBinding
import ru.geekbrain.android.gitapp.repo.FakeUserRepoImpl
import ru.geekbrain.android.gitapp.repo.UsersRepo
import ru.geekbrain.android.gitapp.ui.UsersAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter= UsersAdapter()
    private val userRepo: UsersRepo = FakeUserRepoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.refreshButton.setOnClickListener{
            userRepo.getUsers (
                onSuccess = adapter::setDate,   //передаем метод в лямду onSuccess сигнатура должна совпадать
                onError = {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                }
            )
        }

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.usersRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.usersRecyclerView.adapter = adapter

    }
}