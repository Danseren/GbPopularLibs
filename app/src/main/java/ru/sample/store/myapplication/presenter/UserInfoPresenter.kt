package ru.sample.store.myapplication.presenter

import moxy.MvpPresenter
import ru.sample.store.myapplication.GeekBrainsApp
import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.view.UserView

class UserInfoPresenter(
    private val router: GithubUser
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
    }

    fun onBackPressed() : Boolean {
        GeekBrainsApp.instance.router.exit()
        return true
    }
}