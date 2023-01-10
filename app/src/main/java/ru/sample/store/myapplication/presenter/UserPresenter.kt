package ru.sample.store.myapplication.presenter

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.sample.store.myapplication.core.navigation.UsersScreen
import ru.sample.store.myapplication.repository.GithubRepository
import ru.sample.store.myapplication.view.UserView

class UserPresenter(
    private val repository: GithubRepository,
    private val router: Router
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    private fun loadData() {

        repository.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.initList(it)
                    viewState.hideLoading()
                },
                {

                }
            )
    }

    fun onItemClicked(login: String) {
        router.navigateTo(UsersScreen().userInfo(login))
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}