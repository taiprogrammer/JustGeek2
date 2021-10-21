package com.example.justgeek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.view.isVisible
import com.example.justgeek.api.ApiInterface
import com.example.justgeek.api.RetrofitInstance
import com.example.justgeek.models.UserBody
import okhttp3.ResponseBody
import retrofit2.Response
import java.util.regex.Pattern

class SignUpPassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_password)

        val password = findViewById<AppCompatEditText>(R.id.input_password_sign_up)
        val confirmPassword = findViewById<AppCompatEditText>(R.id.confirm_password)
        val errorMessage = findViewById<AppCompatTextView>(R.id.error_message_password)
        val errorMessageConfirm = findViewById<AppCompatTextView>(R.id.error_message_confirm_password)
        val pageIndicator = findViewById<AppCompatTextView>(R.id.page_indicator_password)
        pageIndicator.text = resources.getString(R.string.page_indicator_text_sign_up, 5)
        val buttonNext = findViewById<AppCompatButton>(R.id.continue_button)
        val validPassword = findViewById<AppCompatImageView>(R.id.check_password)
        val validConfirm = findViewById<AppCompatImageView>(R.id.check_confirm_password)
        val invalidPassword = findViewById<AppCompatImageView>(R.id.check_invalid_password)
        val invalidConfirm = findViewById<AppCompatImageView>(R.id.check_invalid_confirm_password)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val backButton = findViewById<AppCompatButton>(R.id.back_button)

        var passwordResult: String? = null

        password.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                val pattern =  Pattern.compile("[A-Za-z0-9]*([a-zA-Z]+[0-9]+|[0-9]+[a-zA-Z]+)")
                val matcher = pattern.matcher(password.text.toString())
                when {
                    password.text.isNullOrEmpty() -> {
                        validPassword.visibility = View.INVISIBLE
                        invalidPassword.visibility = View.VISIBLE
                        errorMessage.isVisible = true
                        buttonNext.isClickable = false
                        errorMessage.text = resources.getString(R.string.error_message, "Você precisa inserir uma senha.")
                    }
                    password.text!!.trim().toString().length < 8 -> {
                        validPassword.visibility = View.INVISIBLE
                        invalidPassword.visibility = View.VISIBLE
                        errorMessage.isVisible = true
                        buttonNext.isClickable = false
                        errorMessage.text = resources.getString(R.string.error_message, "Sua senha precisa ter mais de 8 caracteres.")
                    }
                    !matcher.matches() -> {
                        validPassword.visibility = View.INVISIBLE
                        invalidPassword.visibility = View.VISIBLE
                        errorMessage.isVisible = true
                        buttonNext.isClickable = false
                        errorMessage.text = resources.getString(R.string.error_message, "Sua senha precisa conter pelo menos uma letra e um número.")
                    }
                    password.text!!.trim().toString().length < 8 && !matcher.matches() -> {
                        validPassword.visibility = View.INVISIBLE
                        invalidPassword.visibility = View.VISIBLE
                        errorMessage.isVisible = true
                        buttonNext.isClickable = false
                        errorMessage.text = resources.getString(R.string.error_message, "Sua senha precisa ter mais de 8 caracteres.\nSua senha precisa conter pelo menos uma letra e um número.")
                    }
                    else -> {
                        validPassword.visibility = View.VISIBLE
                        invalidPassword.visibility = View.GONE
                        errorMessage.isVisible = false
                        buttonNext.isClickable = true
                        passwordResult = password.text.toString()
                    }
                }

            }
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        })

        confirmPassword.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                when {
                    confirmPassword.text.isNullOrEmpty() -> {
                        invalidConfirm.visibility = View.VISIBLE
                        validConfirm.visibility = View.INVISIBLE
                        errorMessageConfirm.isVisible = true
                        buttonNext.isClickable = false
                        errorMessageConfirm.text = resources.getString(R.string.error_message, "Você precisa inserir uma senha.")
                    }
                    confirmPassword.text.toString() != passwordResult -> {
                        invalidConfirm.visibility = View.VISIBLE
                        validConfirm.visibility = View.INVISIBLE
                        errorMessageConfirm.isVisible = true
                        buttonNext.isClickable = false
                        errorMessageConfirm.text = resources.getString(R.string.error_message, "Suas senhas não são iguais.")
                    }
                    else -> {
                        invalidConfirm.visibility = View.INVISIBLE
                        validConfirm.visibility = View.VISIBLE
                        errorMessageConfirm.isVisible = false
                        buttonNext.isClickable = true
                    }
                }

            }
            override fun beforeTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

            override fun onTextChanged(s: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        })

        toolbar.setNavigationOnClickListener { finish() }

        backButton.setOnClickListener { finish() }



        val getNome = intent.getStringExtra("firstName")
        val getSobrenome = intent.getStringExtra("lastName")
        val getCpf = intent.getStringExtra("cpf")
        val getDataNascimento = intent.getStringExtra("birthdate")
        val getEmail = intent.getStringExtra("email")
        val getCellphone = intent.getStringExtra("cellphone")
    }

    private fun signup(nome: String, sobrenome : String, cpf : String, dataNascimento : String,
                       email: String,telefone: String, senha: String
                       ){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val registerInfo = UserBody(nome, sobrenome, cpf, dataNascimento,email,senha,telefone)

        retIn.registerUser(registerInfo).enqueue(object :
            retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    this@SignUpPassword,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override  fun onResponse(call: retrofit2.Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 201) {
                    Toast.makeText(this@SignUpPassword, "Registration success!", Toast.LENGTH_SHORT)
                        .show()

                }
                else{
                    Toast.makeText(this@SignUpPassword, "Registration failed!", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        })
    }
}