package ru.sample.store.myapplication.core

import ru.sample.store.myapplication.core.network.RepoDto
import ru.sample.store.myapplication.model.GithubRepo

object RepoMapper {

    fun map(repoDto: RepoDto): GithubRepo {
        return GithubRepo(
            id = repoDto.id,
            forks = repoDto.forks,
            name = repoDto.name
        )
    }
}