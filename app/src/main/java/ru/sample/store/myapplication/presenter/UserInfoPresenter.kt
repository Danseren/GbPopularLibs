package ru.sample.store.myapplication.presenter

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.sample.store.myapplication.GeekBrainsApp
import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.repository.GithubRepository
import ru.sample.store.myapplication.utils.disposeBy
import ru.sample.store.myapplication.utils.subscribeByDefault
import ru.sample.store.myapplication.view.UserInfoView
import ru.sample.store.myapplication.view.UserView

class UserInfoPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserInfoView>() {

    private val bag = CompositeDisposable()

    fun loadUser(login: String) {
        viewState.showLoading()
        repository.getUserById(login)
            .subscribeByDefault()
            .subscribe(
                {
                   viewState.showUserProfile(it)
                    viewState.hideLoading()
                },
                {

                }
            ).disposeBy(bag)
    }

    fun onBackPressed() : Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        super.onDestroy()
        bag.dispose()
    }
}