package com.example.nestedlayouts

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var horizontalViews: List<TextView>
    private lateinit var verticalViews: List<TextView>
    private lateinit var views: List<TextView>
    private var currentClickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        horizontalViews = listOf(
            findViewById(R.id.horizontal1),
            findViewById(R.id.horizontal2),
            findViewById(R.id.horizontal3)
        )

        verticalViews = listOf(
            findViewById(R.id.vertical1),
            findViewById(R.id.vertical2),
            findViewById(R.id.vertical3)
        )

        views = listOf(
            findViewById(R.id.textView1),
            findViewById(R.id.textView2),
            findViewById(R.id.textView3)
        )

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            handleButtonClick()
        }
    }
    private fun handleButtonClick() {
        clearAllTextViews()

        currentClickCount++

        val valueToSet = currentClickCount

        if (currentClickCount <= 3) {
            horizontalViews[currentClickCount - 1].text = valueToSet.toString()
            verticalViews[currentClickCount - 1].text = valueToSet.toString()
            views[currentClickCount - 1].text = valueToSet.toString()
        }
    }
    private fun clearAllTextViews() {
        for (textView in horizontalViews) {
            textView.text = ""
        }
        for (textView in verticalViews) {
            textView.text = ""
        }
        for (textView in views) {
            textView.text = ""
        }
    }

}





