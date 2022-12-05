package ru.sample.store.myapplication.model

import ru.sample.store.myapplication.utils.START_VALUE

class CountersModel {

    private val counters = mutableListOf(START_VALUE, START_VALUE, START_VALUE)

    fun getCurrent(position: Int): Int {
        return counters[position]
    }

    fun next(position: Int): Int {
        return counters[position]++
    }

    fun set(position: Int, value: Int) {
        counters[position] = value
    }
}