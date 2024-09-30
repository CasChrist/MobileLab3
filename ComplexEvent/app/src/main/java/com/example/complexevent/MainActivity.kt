package com.example.complexevent

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.CheckBox
import android.widget.ProgressBar
import android.widget.TextView



class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var checkBox: CheckBox
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        editText = findViewById(R.id.editText)
        checkBox = findViewById(R.id.checkBox)
        button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        progressBar = findViewById(R.id.progressBar)



        button.setOnClickListener {
            if (checkBox.isChecked) {
                val progress = progressBar.progress
                if (progress + 10 <= 100) {
                    progressBar.progress = progress + 10
                }

                val inputText = editText.text.toString()
                textView.text = inputText
            }
        }

    }
}