package com.example.justgeek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView

class TutorialFirstThree : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_first_three)

        val backStep = findViewById<AppCompatImageView>(R.id.ic_back_step_two)
        val nextStep = findViewById<AppCompatImageView>(R.id.ic_go_to_step_four)

        backStep.setOnClickListener { finish() }

        nextStep.setOnClickListener {
            Intent(this, TutorialFirstFour::class.java)
        }

    }
}