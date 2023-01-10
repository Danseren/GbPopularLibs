package ru.sample.store.myapplication.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubRepo(
    val id: Long,
    val forks: Int,
    val name: String
) : Parcelable
