package ru.sample.store.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import ru.sample.store.myapplication.databinding.ActivityMainBinding

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
                presenter.onCounterClick(R.id.btnFirstCounter)
            }

            btnSecondCounter.setOnClickListener {
                presenter.onCounterClick(R.id.btnSecondCounter)
            }

            btnThirdCounter.setOnClickListener {
                presenter.onCounterClick(R.id.btnThirdCounter)
            }
        }
    }

    private fun initPresenter() {
        presenter = CountersPresenter(this)
    }

    override fun setText(counter: String, position: Int) {
        with(binding) {
            when (position) {
                0 -> tvFirstCounter.text = counter
                1 -> tvSecondCounter.text = counter
                2 -> tvThirdCounter.text = counter
            }
        }
    }

}