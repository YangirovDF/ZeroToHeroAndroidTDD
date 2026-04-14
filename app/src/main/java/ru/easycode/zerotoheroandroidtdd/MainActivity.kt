package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private var tv: TextView? = null
    private lateinit var linearLayout: LinearLayout
    private lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayout = findViewById<LinearLayout>(R.id.rootLayout)
        tv = findViewById(R.id.titleTextView)
        btn = findViewById(R.id.removeButton)


        btn.setOnClickListener {
            try {
                linearLayout.removeView(tv)
            } catch (e: Exception) {
                Log.e("MainActivity", e.toString())
            }
        }
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val removedTextView = savedInstanceState.getBoolean("key")
        if (removedTextView) {
            linearLayout.removeView(tv)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val removedTextView = linearLayout.childCount == 1
        outState.putBoolean("key", removedTextView)
    }

}