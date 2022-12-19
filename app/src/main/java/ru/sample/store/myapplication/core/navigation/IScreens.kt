package ru.sample.store.myapplication.core.navigation

import android.os.Bundle
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen

interface IScreens {
    fun users(): Screen
    fun userInfo(bundle: Bundle): FragmentScreen
}