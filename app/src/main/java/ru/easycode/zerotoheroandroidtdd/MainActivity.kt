package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var tv: TextView
    private lateinit var btn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.titleTextView)
        btn = findViewById(R.id.changeButton)

        btn.setOnClickListener {
            tv.text = "I am an Android Developer!"
        }
        savedInstanceState?.let {
            tv.text = savedInstanceState.getString("key")
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("key", tv.text.toString())
    }


}