package ru.sample.store.myapplication.presenter

import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.view.IUserListPresenter
import ru.sample.store.myapplication.view.UserItemView

class UsersListPresenter : IUserListPresenter {
    val users = mutableListOf<GithubUser>()

    override var itemClickListener: ((UserItemView) -> Unit)? = null

    override fun getCount() = users.size

    override fun bindView(view: UserItemView) {
        val user = users[view.pos]
        view.setLogin(user)
    }
}
