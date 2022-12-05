package ru.sample.store.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.sample.store.myapplication.databinding.ActivityMainBinding
import ru.sample.store.myapplication.presenter.CountersPresenter
import ru.sample.store.myapplication.utils.FIRST_POSITION
import ru.sample.store.myapplication.utils.SECOND_POSITION
import ru.sample.store.myapplication.utils.THIRD_POSITION

class MainActivity : AppCompatActivity(), MainView {

    private lateinit var binding: ActivityMainBinding

    private lateinit var presenter: CountersPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initPresenter()

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

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setText(counter: String, position: Int) {
        with(binding) {
            when (position) {
                FIRST_POSITION -> tvFirstCounter.text = counter
                SECOND_POSITION -> tvSecondCounter.text = counter
                THIRD_POSITION -> tvThirdCounter.text = counter
            }
        }
    }

}