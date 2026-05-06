package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay

class MainViewModel: ViewModel() {

    val currentName: MutableLiveData<State> by lazy {
        MutableLiveData<State>()
    }
    private var state: State = State.Initial()

    suspend fun updateState(textView: TextView, progressBar: ProgressBar, button: Button) {
        try {
            state = State.Loading()
            state.apply(textView, progressBar, button)
            delay(3500)
        } finally {
            state = State.Finished()
            state.apply(textView, progressBar, button)
            currentName.value = state
        }
    }
}