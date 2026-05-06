package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface State {

    fun apply(textView: TextView, progressBar: ProgressBar, button: Button)

    class Initial() : State {
        override fun apply(
            textView: TextView,
            progressBar: ProgressBar,
            button: Button
        ) {
            textView.visibility = View.GONE
            progressBar.visibility = View.GONE
            button.isEnabled = true
        }

    }

    class Loading() : State {
        override fun apply(
            textView: TextView,
            progressBar: ProgressBar,
            button: Button
        ) {
            textView.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
            button.isEnabled = false
        }
    }

    class Finished() : State {
        override fun apply(
            textView: TextView,
            progressBar: ProgressBar,
            button: Button
        ) {
            textView.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            button.isEnabled = true
        }
    }

}