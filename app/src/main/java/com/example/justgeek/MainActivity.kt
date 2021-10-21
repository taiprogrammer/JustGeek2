package com.example.justgeek

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.justgeek.api.ApiInterface
import com.example.justgeek.api.RetrofitInstance
import com.example.justgeek.models.SignInBody
import okhttp3.ResponseBody
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSignIn : AppCompatButton = findViewById(R.id.button_sign_in)

        val btnSignUp : AppCompatButton = findViewById(R.id.button_sign_up)

        btnSignUp.setOnClickListener { v -> goToSignUpPage(v) }

        btnSignIn.setOnClickListener { v -> logged(v) }
    }

    fun goToSignUpPage(v:View) {
        startActivity(Intent(this, SignUpName::class.java))
    }

    fun logged(v: View){
        val inputEmail: AppCompatEditText = findViewById(R.id.input_email)
        val inputSenha: AppCompatEditText = findViewById(R.id.input_password)

        signin(inputEmail.text.toString(),inputSenha.text.toString())
    }

    private fun signin(email: String, password: String){
        val retIn = RetrofitInstance.getRetrofitInstance().create(ApiInterface::class.java)
        val signInInfo = SignInBody(email, password)
        retIn.signin(signInInfo).enqueue(object : retrofit2.Callback<ResponseBody> {
            override fun onFailure(call: retrofit2.Call<ResponseBody>, t: Throwable) {
                Toast.makeText(
                    this@MainActivity,
                    t.message,
                    Toast.LENGTH_SHORT
                ).show()
            }
            override fun onResponse(call: retrofit2.Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.code() == 200) {
                    Toast.makeText(this@MainActivity, "Login success!", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@MainActivity, TutorialAccessFirst::class.java))
                } else {
                    Toast.makeText(this@MainActivity, "Login failed!", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}