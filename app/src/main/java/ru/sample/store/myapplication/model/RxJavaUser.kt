package ru.sample.store.myapplication.model

import io.reactivex.rxjava3.core.Observable

interface RxJavaUser {
    fun fromIterable() : Observable<GithubUser>
}