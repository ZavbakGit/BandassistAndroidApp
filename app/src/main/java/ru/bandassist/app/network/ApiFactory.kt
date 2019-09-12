package ru.bandassist.app.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.bandassist.app.Constants
import ru.bandassist.app.network.api.AuthApi


/**
 *The interface which provides methods to get result of webservices
 */
object ApiFactory {

    private val configInterceptor = Interceptor {
        val configUrl = it.request().url()
            .newBuilder()
            .addQueryParameter("uid", Constants.UID)
            .addQueryParameter("platform", "Android")
            .addQueryParameter("app_version", Constants.APP_VERSION)
            .addQueryParameter("version_os", Constants.OS_VERSION)
            .build()

        val configRequest = it.request()
            .newBuilder()
            .url(configUrl)
            .build()

        it.proceed(configRequest)
    }

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val authClient = OkHttpClient().newBuilder()
        .addInterceptor(configInterceptor)
        .addInterceptor(LogJSONInterceptor())
        .addInterceptor(loggingInterceptor)
        .build()


    private val retrofit by lazy { Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(authClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
    }

    val authApi: AuthApi = retrofit.create(AuthApi::class.java)
}