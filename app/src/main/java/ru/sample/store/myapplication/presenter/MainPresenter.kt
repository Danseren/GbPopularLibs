package ru.sample.store.myapplication.presenter

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.sample.store.myapplication.core.navigation.UsersScreen
import ru.sample.store.myapplication.view.MainView

class MainPresenter(
    private val router: Router
): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(UsersScreen().users())
    }

    fun onBackPressed() {
        router.exit()
    }
}