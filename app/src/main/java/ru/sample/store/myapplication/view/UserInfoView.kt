package ru.sample.store.myapplication.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.sample.store.myapplication.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserInfoView : MvpView {
    fun showUserProfile(user: GithubUser)
    fun showLoading()
    fun hideLoading()
}