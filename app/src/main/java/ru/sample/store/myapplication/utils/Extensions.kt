package ru.sample.store.myapplication.utils

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import ru.sample.store.myapplication.R

fun ImageView.loadImage(url: String?) {
    Glide.with(context)
        .load(url)
        .placeholder(R.drawable.ic_user_placeholder)
        .into(this)
}

fun <T> Single<T>.subscribeByDefault(): Single<T> {
    return this
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}

fun Disposable.disposeBy(bag: CompositeDisposable) {
    bag.add(this)
}

fun View.makeVisible() {
    this.visibility = View.VISIBLE
}

fun View.makeGone() {
    this.visibility = View.GONE
}