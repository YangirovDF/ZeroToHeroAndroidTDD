package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable


class MainActivity : AppCompatActivity() {

    private var state: State = State.Initial
    private lateinit var linearLayout: LinearLayout
    private lateinit var textView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayout = findViewById(R.id.rootLayout)
        val button = findViewById<Button>(R.id.removeButton)
        textView = findViewById(R.id.titleTextView)




        button.setOnClickListener {
            state = State.Removed
            state.apply(linearLayout, textView)
            linearLayout.removeView(textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("key", state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            state = savedInstanceState.getSerializable("key" , State::class.java) as State
        } else {
            state = savedInstanceState.getSerializable("key") as State
        }
        state.apply(linearLayout, textView)
    }

    companion object {
        private const val KEY = "key"
    }

}


interface State: Serializable {

    fun apply(linearLayout: LinearLayout, textView: TextView) = Unit

    object Initial: State {
        override fun apply(linearLayout: LinearLayout, textView: TextView) = Unit
    }


    object Removed: State {

        override fun apply(linearLayout: LinearLayout, textView: TextView) {
            try {
                linearLayout.removeView(textView)
            } catch (e: Exception) {
                Log.e("MainActivity", e.toString())
            }
        }
    }
}