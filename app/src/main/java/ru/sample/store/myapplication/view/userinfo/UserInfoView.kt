package ru.sample.store.myapplication.view.userinfo

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import ru.sample.store.myapplication.model.GithubRepo
import ru.sample.store.myapplication.model.GithubUser

@StateStrategyType(AddToEndSingleStrategy::class)
interface UserInfoView : MvpView {
    fun showUserProfile(user: GithubUser, repo: List<GithubRepo>)
    fun showLoading()
    fun hideLoading()
}