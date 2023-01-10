package ru.sample.store.myapplication.core.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RepoDto(
    @Expose
    @SerializedName("id")
    val id: Long,
    @Expose
    @SerializedName("forks")
    val forks: Int,
    @Expose
    @SerializedName("full_name")
    val name: String

)
