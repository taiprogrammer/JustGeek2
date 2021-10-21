package com.example.justgeek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.isVisible

class SignUpName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_name)
        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        val pageIndicator = findViewById<AppCompatTextView>(R.id.page_indicator)
        val firstName : AppCompatEditText = findViewById(R.id.input_name)
        val lastName : AppCompatEditText = findViewById(R.id.input_last_name)
        val validName = findViewById<AppCompatImageView>(R.id.check_name)
        val validLastName = findViewById<AppCompatImageView>(R.id.check_last_name)
        val invalidName = findViewById<AppCompatImageView>(R.id.check_invalid_name)
        val invalidLastName = findViewById<AppCompatImageView>(R.id.check_invalid_last_name)
        val errorMessage = findViewById<AppCompatTextView>(R.id.error_message_name)
        val errorMessageLastName = findViewById<AppCompatTextView>(R.id.error_message_last_name)
        pageIndicator?.text = resources.getString(R.string.page_indicator_text_sign_up, 1)

        var valid: Boolean = false
        var validL: Boolean = false

        firstName.addTextChangedListener(
            object: TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    val filteredTextName = firstName.text?.trim()?.length
                    if (filteredTextName != null) {
                        when {
                            firstName.text.isNullOrEmpty() -> {
                                invalidName?.visibility = View.VISIBLE
                                validName?.visibility = View.INVISIBLE
                                errorMessage?.isVisible = true
                                errorMessage?.text = resources.getString(
                                    R.string.error_message,
                                    "Você precisa inserir um nome válido."
                                )
                                valid = false
                            }
                            filteredTextName <= 2 -> {
                                invalidName?.visibility = View.VISIBLE
                                validName?.visibility = View.INVISIBLE
                                errorMessage?.isVisible = true
                                errorMessage?.text = resources.getString(
                                    R.string.error_message,
                                    "Seu nome precisa ter mais de duas letras!"
                                )
                                valid = false
                            }
                            else -> {
                                validName?.visibility = View.VISIBLE
                                invalidName?.visibility = View.GONE
                                errorMessage?.isVisible = false
                                valid = true
                            }
                        }
                    }
                }
                override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

                override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            }
        )

        lastName.addTextChangedListener(
            object: TextWatcher {
                override fun afterTextChanged(s: Editable?) {
                    val filteredTextLastName = lastName.text?.trim()?.length
                    if (filteredTextLastName != null) {
                        when {
                            lastName.text.isNullOrEmpty() -> {
                                invalidLastName?.visibility = View.VISIBLE
                                validLastName?.visibility = View.INVISIBLE
                                errorMessageLastName?.isVisible = true
                                errorMessageLastName?.text = resources.getString(
                                    R.string.error_message,
                                    "Você precisa inserir um sobrenome válido."
                                )
                                validL = false
                            }
                            filteredTextLastName <= 2 -> {
                                invalidLastName?.visibility = View.VISIBLE
                                validLastName?.visibility = View.INVISIBLE
                                errorMessageLastName?.isVisible = true
                                errorMessageLastName?.text = resources.getString(
                                    R.string.error_message,
                                    "Seu sobrenome precisa ter mais de duas letras!"
                                )
                                validL = false
                            }
                            else -> {
                                validLastName?.visibility = View.VISIBLE
                                invalidLastName?.visibility = View.GONE
                                errorMessageLastName?.isVisible = false
                                validL = true
                            }
                        }
                    }
                }
                override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

                override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            }
        )

        toolbar.setNavigationOnClickListener {
            if (!valid && !validL) {
                finish()
            }
        }
    }


    fun goToCpfScreen(v:View) {
        val firstName : AppCompatEditText = findViewById(R.id.input_name)
        val lastName : AppCompatEditText = findViewById(R.id.input_last_name)

        val screen_cpf = Intent(this, SignUpCpf::class.java)

        screen_cpf.putExtra("firstName", firstName.text.toString())
        screen_cpf.putExtra("lastName", lastName.text.toString())

        startActivity(screen_cpf)
    }
}