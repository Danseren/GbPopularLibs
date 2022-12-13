package ru.sample.store.myapplication.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.sample.store.myapplication.repository.GithubRepository
import ru.sample.store.myapplication.view.UserView

class UserPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initList(repository.getUsers())
    }

    fun onBackPressed() : Boolean {
        router.exit()
        return true
    }
}