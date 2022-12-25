package ru.sample.store.myapplication.core.navigation

import android.os.Bundle
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.sample.store.myapplication.model.GithubUser

interface IScreens {
    fun users(): Screen
    fun userInfo(user: GithubUser): FragmentScreen
}