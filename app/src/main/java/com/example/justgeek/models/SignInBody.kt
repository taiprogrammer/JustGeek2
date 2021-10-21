package com.example.justgeek.models

import com.google.gson.annotations.SerializedName

data class SignInBody(
    @SerializedName("email")
    val email : String,
    @SerializedName("senha")
    val senha : String
)
