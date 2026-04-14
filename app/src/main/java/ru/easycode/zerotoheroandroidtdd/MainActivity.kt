package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var tv: TextView? = null
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.titleTextView)
        btn = findViewById(R.id.removeButton)

        savedInstanceState?.let {
            if (!savedInstanceState.getBoolean("key")) {
                (tv?.parent as ViewGroup).removeView(tv)
            }
        }

        btn.setOnClickListener {
            try {
                (tv?.parent as ViewGroup).removeView(tv)
            } catch (e: Exception) {
                Log.e("MainActivity", e.toString())
            }
        }
    }

}