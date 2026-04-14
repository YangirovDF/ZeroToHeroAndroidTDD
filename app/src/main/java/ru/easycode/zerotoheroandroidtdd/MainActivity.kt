package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var tv: TextView
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.titleTextView)
        btn = findViewById(R.id.hideButton)

        savedInstanceState?.let {
            if (savedInstanceState.getBoolean("key")) {
                tv.visibility = View.VISIBLE
            } else {
                tv.visibility = View.GONE
            }
        }

        btn.setOnClickListener {
            tv.visibility = View.GONE
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("key", tv.isVisible)
    }




}