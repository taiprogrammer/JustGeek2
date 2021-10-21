package com.example.justgeek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView

class TutorialFirstFour : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_first_four)

        val backButton = findViewById<AppCompatImageView>(R.id.ic_back_to_step_four)

        backButton.setOnClickListener { finish() }
    }
}