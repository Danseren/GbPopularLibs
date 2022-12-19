package ru.sample.store.myapplication.presenter

import android.os.Bundle
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.sample.store.myapplication.core.navigation.UsersScreen
import ru.sample.store.myapplication.repository.GithubRepository
import ru.sample.store.myapplication.utils.USER_KEY
import ru.sample.store.myapplication.view.UserView

class UserPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserView>() {

    val userListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList()
        loadData()
        userListPresenter.itemClickListener = { itemView ->
            val user = userListPresenter.users[itemView.pos]
            val bundle = Bundle()
            bundle.putParcelable(USER_KEY, user)
            router.navigateTo(UsersScreen().userInfo(bundle))
        }
    }

    private fun loadData() {
        val users = repository.getUsers()
        userListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun onBackPressed() : Boolean {
        router.exit()
        return true
    }
}