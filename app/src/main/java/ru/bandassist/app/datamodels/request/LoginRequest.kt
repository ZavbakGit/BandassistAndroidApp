package ru.bandassist.app.datamodels.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    val email: String,
    @SerializedName("password_str")
    val password: String,
    @SerializedName("push_token")
    val pushToken: String
)
