package ru.sample.store.myapplication.presenter

import ru.sample.store.myapplication.view.MainView
import ru.sample.store.myapplication.model.CountersModel
import ru.sample.store.myapplication.utils.FIRST_POSITION
import ru.sample.store.myapplication.utils.SECOND_POSITION
import ru.sample.store.myapplication.utils.THIRD_POSITION

class CountersPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun onFirstCounterClick() {
        view.setText(model.next(FIRST_POSITION).toString(), FIRST_POSITION)
    }

    fun onSecondCounterClick() {
        view.setText(model.next(SECOND_POSITION).toString(), SECOND_POSITION)
    }

    fun onThirdCounterClick() {
        view.setText(model.next(THIRD_POSITION).toString(), THIRD_POSITION)
    }
}