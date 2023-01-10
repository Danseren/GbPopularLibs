package ru.sample.store.myapplication.core.navigation

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.sample.store.myapplication.utils.USER_KEY
import ru.sample.store.myapplication.view.userinfo.UserInfoFragment
import ru.sample.store.myapplication.view.userlist.UserListFragment

class UsersScreen : IScreens {
    override fun users(): Screen = FragmentScreen() {
        UserListFragment.getInstance()
    }

    override fun userInfo(login: String): FragmentScreen =
        FragmentScreen(USER_KEY) {
            UserInfoFragment.getInstance(login)
    }

}