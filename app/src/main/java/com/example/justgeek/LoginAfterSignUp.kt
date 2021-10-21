package com.example.justgeek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar

class LoginAfterSignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_after_sign_up)

        val loginButton = findViewById<AppCompatButton>(R.id.login_button)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)

        toolbar.setNavigationOnClickListener { finish() }

        loginButton.setOnClickListener {
            Intent(this, MainActivity::class.java)
        }
    }
}