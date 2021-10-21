package com.example.justgeek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar

class SignUpBirthdate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_birthdate)
        val buttonBack = findViewById<AppCompatButton>(R.id.back_button)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val buttonNext = findViewById<AppCompatButton>(R.id.continue_button)
        val birthDate = findViewById<AppCompatEditText>(R.id.input_birthdate)
        val pageIndicator = findViewById<AppCompatTextView>(R.id.page_indicator_birthday)
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 3)

        toolbar.setNavigationOnClickListener { finish() }

        buttonBack.setOnClickListener { finish() }
    }

    fun goToEmailCellphoneScreen(v:View) {
        val birthdate : AppCompatEditText = findViewById(R.id.input_birthdate)

        val email_cellphone_screen = Intent(this, SignUpEmailCellphone::class.java)

        email_cellphone_screen.putExtra("birthdate", birthdate.text.toString())

        startActivity(email_cellphone_screen)
    }
}