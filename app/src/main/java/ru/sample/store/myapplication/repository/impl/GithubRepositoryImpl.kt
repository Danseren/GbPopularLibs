package ru.sample.store.myapplication.repository.impl

import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.repository.GithubRepository

class GithubRepositoryImpl : GithubRepository {

    private val repository = listOf(
        GithubUser("Andreev"),
        GithubUser("Petrov"),
        GithubUser("Ivanov"),
        GithubUser("Sidorov"),
        GithubUser("Sergeev")
    )

    override fun getUsers(): List<GithubUser> {
        return repository
    }
}