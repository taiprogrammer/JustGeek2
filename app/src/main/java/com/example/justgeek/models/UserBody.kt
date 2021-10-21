package com.example.justgeek.models

import com.google.gson.annotations.SerializedName

data class UserBody(
    @SerializedName("nome")
    val nome : String,
    @SerializedName("sobrenome")
    val sobrenome : String,
    @SerializedName("dataNascimento")
    val dataNascimento : String,
    @SerializedName("cpf")
    val cpf : String,
    @SerializedName("celular")
    val celular : String,
    @SerializedName("email")
    val email : String,
    @SerializedName("senha")
    val senha : String
)
