package ru.sample.store.myapplication.view

import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.sample.store.myapplication.R
import ru.sample.store.myapplication.databinding.ActivityMainBinding
import ru.sample.store.myapplication.model.CountersModel
import ru.sample.store.myapplication.presenter.CountersPresenter

class MainActivity : MvpAppCompatActivity(R.layout.activity_main), MainView {

    private lateinit var binding: ActivityMainBinding

    private val presenter by moxyPresenter {
        CountersPresenter(CountersModel())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnFirstCounter.setOnClickListener {
                presenter.onFirstCounterClick()
            }

            btnSecondCounter.setOnClickListener {
                presenter.onSecondCounterClick()
            }

            btnThirdCounter.setOnClickListener {
                presenter.onThirdCounterClick()
            }
        }
    }

    override fun setFirstCounter(counter: String) = with(binding) {
        tvFirstCounter.text = counter
    }

    override fun setSecondCounter(counter: String) = with(binding) {
        tvSecondCounter.text = counter
    }

    override fun setThirdCounter(counter: String) = with(binding) {
        tvThirdCounter.text = counter
    }

}