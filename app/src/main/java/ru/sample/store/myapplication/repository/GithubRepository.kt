package ru.sample.store.myapplication.repository

import ru.sample.store.myapplication.model.GithubUser

interface GithubRepository {
    fun getUsers(): List<GithubUser>
}