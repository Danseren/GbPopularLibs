package ru.sample.store.myapplication.presenter

import moxy.MvpPresenter
import ru.sample.store.myapplication.view.MainView
import ru.sample.store.myapplication.model.CountersModel
import ru.sample.store.myapplication.utils.FIRST_POSITION
import ru.sample.store.myapplication.utils.SECOND_POSITION
import ru.sample.store.myapplication.utils.THIRD_POSITION

class CountersPresenter(
    private val model: CountersModel
): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        //INIT
    }

    fun onFirstCounterClick() {
        viewState.setFirstCounter(model.next(FIRST_POSITION).toString())
    }

    fun onSecondCounterClick() {
        viewState.setSecondCounter(model.next(SECOND_POSITION).toString())    }

    fun onThirdCounterClick() {
        viewState.setThirdCounter(model.next(THIRD_POSITION).toString())    }
}