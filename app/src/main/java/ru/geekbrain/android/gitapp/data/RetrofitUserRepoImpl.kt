package ru.geekbrain.android.gitapp.data

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import ru.geekbrain.android.gitapp.domain.entities.UserEntity
import ru.geekbrain.android.gitapp.domain.repos.UsersRepo

class RetrofitUserRepoImpl: UsersRepo {
    private var baseURL = "https://api.github.com/"
    private var logging = HttpLoggingInterceptor()
    private var client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private var retrofit = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
        .client(client)
        .build()


    private fun getGitHubAPI(): UsersAPI{
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC)
        return retrofit.create(UsersAPI::class.java)
    }

    private fun sendRequest(callback : Callback<ArrayList<UserEntity>>){
        return getGitHubAPI()
            .getUsers()
            .enqueue(callback)
    }

    override fun getUsers(onSuccess: (List<UserEntity>) -> Unit, onError: ((Throwable) -> Unit)?) {
        val callback= object : Callback<ArrayList<UserEntity>> {
            override fun onResponse(call: Call<ArrayList<UserEntity>>, response: Response<ArrayList<UserEntity>>) {
                if (response.isSuccessful)
                    response.body()?.let { onSuccess(it) }
                else{
                    onError?.let{it(IllegalStateException("Something wrong"))}
                }
            }

            override fun onFailure(call: Call<ArrayList<UserEntity>>, t: Throwable) {
                onError?.let { it(t) }
            }

        }

        sendRequest(callback)

    }
}


