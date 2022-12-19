package ru.sample.store.myapplication.view

import ru.sample.store.myapplication.model.GithubUser

interface UserItemView: IItemView {
    fun setLogin(user: GithubUser)
}