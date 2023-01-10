package ru.sample.store.myapplication.repository

import io.reactivex.rxjava3.core.Single
import ru.sample.store.myapplication.model.GithubRepo
import ru.sample.store.myapplication.model.GithubUser

interface GithubRepository {
    fun getUsers(): Single<List<GithubUser>>

    fun getUserById(login: String): Single<GithubUser>

    fun getRepoByLogin(login: String) : Single<List<GithubRepo>>
}