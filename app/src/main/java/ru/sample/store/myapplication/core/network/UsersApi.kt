package ru.sample.store.myapplication.core.network

import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface UsersApi {

    @GET("/users")
    fun getAllUsers(): Single<List<UserDto>>

    @GET("/users/{login}")
    fun getUser(@Path("login") login: String): Single<UserDto>

    @GET("/users/{login}/repos")
    fun getRepo(@Path("login") login: String): Single<List<RepoDto>>
}