package com.example.justgeek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView

class TutorialAccessTwo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_access_two)

        val backStep = findViewById<AppCompatImageView>(R.id.ic_back_step_one)
        val nextStep = findViewById<AppCompatImageView>(R.id.go_to_step_three)

        backStep.setOnClickListener { finish() }

        nextStep.setOnClickListener {
            startActivity(Intent(this, TutorialFirstThree::class.java))
        }
    }
}