package ru.sample.store.myapplication.repository.impl

import io.reactivex.rxjava3.core.Single
import ru.sample.store.myapplication.core.UserMapper
import ru.sample.store.myapplication.core.RepoMapper
import ru.sample.store.myapplication.core.network.UsersApi
import ru.sample.store.myapplication.model.GithubRepo
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

    override fun getRepoByLogin(login: String): Single<List<GithubRepo>> {
        return usersApi.getRepo(login)
            .map { it.map(RepoMapper::map) }
    }

}