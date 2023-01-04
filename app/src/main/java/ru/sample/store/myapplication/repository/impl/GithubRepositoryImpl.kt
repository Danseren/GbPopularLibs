package ru.sample.store.myapplication.repository.impl

import io.reactivex.rxjava3.core.Observable
import ru.sample.store.myapplication.model.GithubUser
import ru.sample.store.myapplication.model.RxJavaUser

class GithubRepositoryImpl : RxJavaUser {
    override fun fromIterable(): Observable<GithubUser> {
        return Observable.fromIterable(
            listOf(
                GithubUser("Andreev"),
                GithubUser("Petrov"),
                GithubUser("Ivanov"),
                GithubUser("Sidorov"),
                GithubUser("Sergeev")
            )
        )
    }
}