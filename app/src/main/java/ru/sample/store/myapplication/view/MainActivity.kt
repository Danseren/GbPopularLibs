package ru.sample.store.myapplication.view

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.sample.store.myapplication.GeekBrainsApp
import ru.sample.store.myapplication.R
import ru.sample.store.myapplication.core.BackPressedListener
import ru.sample.store.myapplication.databinding.ActivityMainBinding
import ru.sample.store.myapplication.presenter.MainPresenter

class MainActivity : MvpAppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding
    private val navigator = AppNavigator(this, R.id.containerMain)

    private val presenter by moxyPresenter {
        MainPresenter(GeekBrainsApp.instance.router)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        GeekBrainsApp.instance.navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        GeekBrainsApp.instance.navigationHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach { currentFragment ->
            if (currentFragment is BackPressedListener && currentFragment.onBackPressed()) {
                return
            }
        }
        presenter.onBackPressed()
    }
}