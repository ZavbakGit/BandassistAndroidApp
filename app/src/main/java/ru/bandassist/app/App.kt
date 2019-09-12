package ru.bandassist.app

import android.app.Application
import android.content.Context


class App: Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: App? = null

        fun appContext(): Context? = instance?.applicationContext
    }

    override fun onCreate() {
        super.onCreate()

        println("App -> Constants.UID: ${Constants.UID}; Platform: Android; APP Version: ${Constants.APP_VERSION}; OS Version: ${Constants.OS_VERSION}")
    }
}