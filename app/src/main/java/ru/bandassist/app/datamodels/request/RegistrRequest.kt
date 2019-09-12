package ru.bandassist.app.datamodels.request

import com.google.gson.annotations.SerializedName

data class RegistrRequest(
    @SerializedName("avatar_image")
    val avatar: String?,
    val email: String,
    val name: String,
    @SerializedName("password_str")
    val password: String,
    @SerializedName("role_in_band")
    val role: String
)