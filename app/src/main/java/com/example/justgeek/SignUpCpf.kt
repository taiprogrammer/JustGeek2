package com.example.justgeek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.widget.*
import androidx.core.view.isVisible

class SignUpCpf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_cpf)
        val buttonBack = findViewById<AppCompatButton>(R.id.back_button)
        val buttonNext = findViewById<AppCompatButton>(R.id.continue_button)
        val cpf = findViewById<AppCompatEditText>(R.id.input_cpf)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val pageIndicator = findViewById<AppCompatTextView>(R.id.page_indicator)
        val errorMessage = findViewById<AppCompatTextView>(R.id.error_message_cpf)
        val checkValid = findViewById<AppCompatImageView>(R.id.check_valid)
        val checkInValid = findViewById<AppCompatImageView>(R.id.check_invalid)
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 2)

        toolbar.setNavigationOnClickListener { finish() }
    }

    fun goToBirthdateScreen(v:View) {
        val cpf : AppCompatEditText = findViewById(R.id.input_cpf)

        val birthdate_screen = Intent(this, SignUpBirthdate::class.java)

        birthdate_screen.putExtra("cpf", cpf.text.toString())

        startActivity(birthdate_screen)
    }

    fun backToName(v:View) {
        finish()
    }
}