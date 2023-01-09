package ru.sample.store.myapplication.repository.impl

import io.reactivex.rxjava3.core.Single
import ru.sample.store.myapplication.core.UserMapper
import ru.sample.store.myapplication.core.network.UsersApi
import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.repository.GithubRepository

class GithubRepositoryImpl constructor(
    private val usersApi: UsersApi
) : GithubRepository {

    override fun getUsers(): Single<List<GithubUser>> {
        return usersApi.getAllUsers()
            .map { it.map(UserMapper::mapToEntity) }
    }

    override fun getUserById(login: String): Single<GithubUser> {
        return usersApi.getUser(login)
            .map(UserMapper::mapToEntity)
    }

}