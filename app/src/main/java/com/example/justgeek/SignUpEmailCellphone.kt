package com.example.justgeek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.*

class SignUpEmailCellphone : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_email_cellphone)
        val buttonBack = findViewById<AppCompatButton>(R.id.back_button)
        val buttonNext = findViewById<AppCompatButton>(R.id.continue_button)
        val email = findViewById<AppCompatEditText>(R.id.input_email_sign_up)
        val cellphone = findViewById<AppCompatEditText>(R.id.input_cellphone)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val pageIndicator = findViewById<AppCompatTextView>(R.id.page_indicator_contacts)
        val checkValidEmail = findViewById<AppCompatImageView>(R.id.check_email)
        val checkInvalidEmail = findViewById<AppCompatImageView>(R.id.check_email_invalid)
        val checkValidCellphone = findViewById<AppCompatImageView>(R.id.cellphone_check)
        val checkInvalidCellphone = findViewById<AppCompatImageView>(R.id.cellphone_check_invalid)
        val errorMessageEmail = findViewById<AppCompatTextView>(R.id.error_message_email)
        val errorMessagePhone = findViewById<AppCompatTextView>(R.id.error_message_phone)
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 4)

        toolbar.setNavigationOnClickListener { finish() }

        buttonBack.setOnClickListener { finish() }
    }

    fun goToPasswordScreen(v:View) {
        val emailText : AppCompatEditText = findViewById(R.id.input_email_sign_up)
        val cellphone : AppCompatEditText = findViewById(R.id.input_cellphone)

        val password_screen = Intent(this, SignUpPassword::class.java)

        password_screen.putExtra("email", emailText.text.toString())
        password_screen.putExtra("cellphone", cellphone.text.toString())

        startActivity(password_screen)
    }
}