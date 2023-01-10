package ru.sample.store.myapplication.presenter

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import ru.sample.store.myapplication.model.GithubRepo
import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.repository.GithubRepository
import ru.sample.store.myapplication.utils.disposeBy
import ru.sample.store.myapplication.utils.subscribeByDefault
import ru.sample.store.myapplication.view.userinfo.UserInfoView

class UserInfoPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserInfoView>() {

    private val bag = CompositeDisposable()

    fun loadUser(login: String) {
        viewState.showLoading()
        Single.zip(
            repository.getUserById(login),
            repository.getRepoByLogin(login)
        ) { user, repos ->
            return@zip Pair<GithubUser, List<GithubRepo>> (user, repos)
        }
            .subscribeByDefault()
            .subscribe(
                {
                   viewState.showUserProfile(it.first, it.second)
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

    fun onRepoClicked(it: Long) {

    }
}