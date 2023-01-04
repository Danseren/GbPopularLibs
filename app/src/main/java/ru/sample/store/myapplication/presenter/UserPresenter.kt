package ru.sample.store.myapplication.presenter

import android.os.Bundle
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter
import ru.sample.store.myapplication.core.navigation.UsersScreen
import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.repository.GithubRepository
import ru.sample.store.myapplication.repository.impl.GithubRepositoryImpl
import ru.sample.store.myapplication.utils.USER_KEY
import ru.sample.store.myapplication.view.UserView

class UserPresenter(
    private val repository: GithubRepositoryImpl,
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
            router.navigateTo(UsersScreen().userInfo(user))
        }
    }

    private fun loadData() {
        val userObserver = object : Observer<GithubUser> {

            var disposable: Disposable? = null

            override fun onSubscribe(d: Disposable) {
                disposable = d
            }

            override fun onNext(t: GithubUser) {
                userListPresenter.users.add(t)
            }

            override fun onError(e: Throwable) {
                //nothing to do
            }

            override fun onComplete() {
                viewState.updateList()
            }
        }

        repository.fromIterable().subscribe(userObserver)
    }

    fun onBackPressed() : Boolean {
        router.exit()
        return true
    }
}