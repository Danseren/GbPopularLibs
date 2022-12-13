package ru.sample.store.myapplication.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.sample.store.myapplication.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserView: MvpView {

    fun initList(list: List<GithubUser>)
}