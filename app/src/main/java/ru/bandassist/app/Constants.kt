package ru.bandassist.app

import android.annotation.SuppressLint
import android.provider.Settings

@SuppressLint("HardwareIds")
object Constants {
    const val BASE_URL = "https://bandassist.ru/v1/"
    const val APP_VERSION = BuildConfig.VERSION_NAME
    val UID by lazy {
        App.appContext()?.let {
            Settings.Secure.getString(it.contentResolver, Settings.Secure.ANDROID_ID)
        }
    }
    val OS_VERSION by lazy { android.os.Build.VERSION.SDK_INT.toString() }
}