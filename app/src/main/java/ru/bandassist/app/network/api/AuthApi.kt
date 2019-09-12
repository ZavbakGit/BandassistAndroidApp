package ru.bandassist.app.network.api

import io.reactivex.Single
import ru.bandassist.app.datamodels.response.LoginResponse
import ru.bandassist.app.datamodels.response.RegistrationResponse
import retrofit2.Response
import retrofit2.http.*
import ru.bandassist.app.datamodels.request.LoginRequest
import ru.bandassist.app.datamodels.request.ResendRequest
import ru.bandassist.app.datamodels.response.ResendResponse

interface AuthApi {

    @POST("auth/confirmation/resend")
    @Headers("content-type: application/json")
    fun resend(@Body body: ResendRequest): Single<Response<ResendResponse>>

    @FormUrlEncoded
    @POST("auth/register")
    fun register(@Query("uid") uid: String,
                 @Query("platform") pl: String,
                 @Query("app_version") version: String,
                 @Query("version_os") os: String,
                 @Field("avatar") avatar: String,
                 @Field("email") email: String,
                 @Field("name") name: String,
                 @Field("password_str") psw: String,
                 @Field("role_in_band") role: String): Single<Response<RegistrationResponse>>


    @POST("auth/login")
    @Headers("content-type: application/json")
    fun login(@Body body: LoginRequest): Single<Response<LoginResponse>>
}