package ru.sample.store.myapplication.core.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.sample.store.myapplication.view.UserFragment

object UsersScreen : IScreens, Screen {
    override fun users() = FragmentScreen {
        UserFragment.getInstance()
    }
}