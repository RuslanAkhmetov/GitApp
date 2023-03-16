package ru.geekbrain.android.gitapp

import android.app.Application
import android.content.Context
import androidx.fragment.app.Fragment
import ru.geekbrain.android.gitapp.data.FakeUserRepoImpl
import ru.geekbrain.android.gitapp.domain.UsersRepo

class App: Application() {
    val UsersRepo: UsersRepo by lazy { FakeUserRepoImpl() }
}

val Context.app: App get() = applicationContext as App

val Fragment.app: App get() = requireContext().applicationContext as App