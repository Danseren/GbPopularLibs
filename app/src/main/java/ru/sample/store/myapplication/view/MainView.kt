package ru.sample.store.myapplication.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView: MvpView {

    fun setFirstCounter(counter: String)

    fun setSecondCounter(counter: String)

    fun setThirdCounter(counter: String)
}