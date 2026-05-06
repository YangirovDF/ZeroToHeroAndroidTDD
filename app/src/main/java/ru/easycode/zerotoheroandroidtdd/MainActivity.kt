package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var progressBar: ProgressBar
    private var loadingJob: Job? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel: MainViewModel by viewModels()

        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.actionButton)
        progressBar = findViewById(R.id.progressBar)


        button.setOnClickListener {
            loadingJob?.cancel()
            loadingJob = lifecycleScope.launch {
            viewModel.updateState(textView, progressBar, button)
            }

        }

        val nameObserver = Observer<State> { state ->
            state.apply(textView,  progressBar, button)
        }

        viewModel.currentName.observe(this, nameObserver)
    }
}