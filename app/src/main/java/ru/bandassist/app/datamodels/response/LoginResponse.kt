package ru.bandassist.app.datamodels.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("access_token")
    val accessToken: String,
    val data: Data,
    val message: String,
    val status: Int
)

data class Data(
    @SerializedName("avatar_image") val avatar: String?,
    @SerializedName("band_name") val bandName: String?,
    @SerializedName("in_band") val inBand: Boolean,
    @SerializedName("name") val name: Boolean,
    @SerializedName("role_in_band") val roleInBand: String?
)
