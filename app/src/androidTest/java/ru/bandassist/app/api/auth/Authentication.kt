package ru.bandassist.app.api.auth

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import ru.bandassist.app.Constants
import ru.bandassist.app.datamodels.request.LoginRequest
import ru.bandassist.app.datamodels.request.ResendRequest
import ru.bandassist.app.network.ApiFactory

/**
 * Проверяю и изучаю, что приходит по api для aut
 */
@RunWith(AndroidJUnit4::class)
class Authentication {
    @Test
    fun register() {

        val appContext = InstrumentationRegistry.getTargetContext()
        val apiSingle =

            ApiFactory.authApi.register(
                uid = Constants.UID ?: "",
                pl = "Android",
                version = Constants.APP_VERSION,
                os = Constants.OS_VERSION,
                avatar = "",
                role = "Manager",
                name = "Alex",
                email = "ag@79955588.ru",
                psw = "1234512345"
            )

        apiSingle
            .subscribe({
                println("\n${it.body()}\n")
                assert(true)
            }, {
                assert(false)
            })

        assert(false)

        //https://bandassist.ru/v1/auth/confirm/eyJhbGciOiJIUzI1NiIsImlhdCI6MTU2ODIwNDUyNCwiZXhwIjoxNTY4ODA5MzI0fQ.eyJjb25maXJtIjoiYWdANzk5MDAwLnJ1In0.yWZMsoWcZHbNTXRXlBMTREtJYWaXYTQWPbzEHlVQWfM
    }

    @Test
    fun login() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()

        val apiSingle = ApiFactory.authApi.login(
            LoginRequest(
                email = "ag@7990005645.ru",
                password = "1234512345",
                pushToken = "eyJhbGciOiJIUzI1NiIsImlhdCI6MTU2ODIwNDUyNCwiZXhwIjoxNTY4ODA5MzI0fQ.eyJjb25maXJtIjoiYWdANzk5MDAwLnJ1In0.yWZMsoWcZHbNTXRXlBMTREtJYWaXYTQWPbzEHlVQWfM"
            )
        )

        apiSingle
            .subscribe({
                println("***************************************")
                println("\n${it.body()}\n")
                assert(true)
            }, {
                assert(false)
            })

        assert(false)
    }

    @Test
    fun resend() {

        val appContext = InstrumentationRegistry.getTargetContext()

        val apiSingle =
            ApiFactory.authApi.resend(
                ResendRequest(email = "ag@799555645.ru")
            )

        apiSingle
            .subscribe({
                println("\n${it.body()}\n")
                assert(true)
            }, {
                assert(false)
            })

        assert(false)
    }
}



