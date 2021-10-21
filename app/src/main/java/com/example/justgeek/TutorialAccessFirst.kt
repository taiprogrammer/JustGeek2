package com.example.justgeek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatImageView

class TutorialAccessFirst : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial_access_first)

        val stepTwo = findViewById<AppCompatImageView>(R.id.go_to_second_step)

        stepTwo.setOnClickListener {
            Intent(this, TutorialAccessTwo::class.java)
        }
    }
}