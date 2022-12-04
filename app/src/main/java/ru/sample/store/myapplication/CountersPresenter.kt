package ru.sample.store.myapplication

class CountersPresenter(private val view: MainView) {

    private val model = CountersModel()

    fun onCounterClick(id: Int) {

        when (id) {
            R.id.btnFirstCounter -> {
                val newValue = model.next(0)
                view.setText(newValue.toString(), 0)
            }
            R.id.btnSecondCounter -> {
                val newValue = model.next(1)
                view.setText(newValue.toString(), 1)
            }
            R.id.btnThirdCounter -> {
                val newValue = model.next(2)
                view.setText(newValue.toString(), 2)
            }
        }
    }
}