package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    companion object {
        const val KEY_INSTANCE_STATE = "KeyInstanceState"
    }

    private lateinit var tv: TextView
    private lateinit var btn: Button
    private var textWhoAmI: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.titleTextView)
        btn = findViewById(R.id.changeButton)


        if (savedInstanceState != null) {
            textWhoAmI = savedInstanceState.getString(KEY_INSTANCE_STATE) ?: ""
            tv.text = textWhoAmI
        }

        btn.setOnClickListener {
            textWhoAmI = "I am an Android Developer!"
            tv.text = textWhoAmI
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_INSTANCE_STATE, textWhoAmI)
    }

}