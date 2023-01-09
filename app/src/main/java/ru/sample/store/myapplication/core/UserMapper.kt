package ru.sample.store.myapplication.core

import ru.sample.store.myapplication.core.network.UserDto
import ru.sample.store.myapplication.model.GithubUser

object UserMapper {

    fun mapToEntity(dto: UserDto): GithubUser {
        return GithubUser(
            id = dto.id,
            login = dto.login,
            avatarURL = dto.avatarUrl
        )
    }
}