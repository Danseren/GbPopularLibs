package ru.sample.store.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import ru.sample.store.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val counters = mutableListOf(0, 0, 0)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            btnFirstCounter.setOnClickListener {
                tvFirstCounter.text = (++counters[0]).toString()
            }

            btnSecondCounter.setOnClickListener {
                tvSecondCounter.text = (++counters[1]).toString()
            }

            btnThirdCounter.setOnClickListener {
                tvThirdCounter.text = (++counters[2]).toString()
            }
        }
    }

    private fun initView() {
        with(binding) {
            tvFirstCounter.text = counters[0].toString()
            tvSecondCounter.text = counters[1].toString()
            tvThirdCounter.text = counters[2].toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray("counters", counters.toIntArray())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val array = savedInstanceState.getIntArray("counters")
        counters.let { list ->
            list.clear()
            array?.toList()?.let {
                list.addAll(it)
            }
        }

        initView()
    }
}