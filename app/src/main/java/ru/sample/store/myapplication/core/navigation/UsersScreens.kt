package ru.sample.store.myapplication.core.navigation

import android.os.Bundle
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.sample.store.myapplication.utils.USER_KEY
import ru.sample.store.myapplication.view.UserInfoFragment
import ru.sample.store.myapplication.view.UserListFragment

class UsersScreen : IScreens {
    override fun users(): Screen = FragmentScreen() {
        UserListFragment.getInstance()
    }

    override fun userInfo(bundle: Bundle): FragmentScreen =
        FragmentScreen(USER_KEY) {
            UserInfoFragment.getInstance().apply { arguments = bundle }
    }
}