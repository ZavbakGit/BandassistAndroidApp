package ru.bandassist.app.api.trytest

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import io.reactivex.Observable

import org.junit.Test
import org.junit.runner.RunWith

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


/**
 * Этим тестом я проверяю что можно тестировать api
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class TryTest {
    @Test
    fun tryTest() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()

        val api = TypicodeApi.create()

        api.getPosts()
            .subscribe {
                println(it.take(3).joinToString("\n"))
                assert(true)
            }

        assert(false)
    }
}


/**
 *The interface which provides methods to get result of webservices
 */
interface TypicodeApi {
    /**
     * Get the list of the pots from the API
     */
    @GET("/posts")
    fun getPosts(): Observable<List<Post>>

    /**
     * Companion object to create the GithubApiService
     */
    companion object Factory {
        fun create(): TypicodeApi {
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com")
                .build()

            return retrofit.create(TypicodeApi::class.java)
        }
    }

}

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
