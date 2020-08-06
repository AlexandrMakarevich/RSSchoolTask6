package by.a_makarevich.rsschooltask6

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface TheTedApi {
    @GET("/artem-bagritsevich/rs.android.task.6/master/data/data.json")
    suspend fun getListOfTeds(): ApiData
}

object WebAccess {
  private val retrofit = Retrofit.Builder()
      .addConverterFactory(MoshiConverterFactory.create())
      .baseUrl("https://raw.githubusercontent.com")
      .build()

    private val  tedService = retrofit.create(TheTedApi::class.java)

    suspend fun getListOfTeds(): List<TedObject>{
        return withContext(Dispatchers.IO) {
            tedService.getListOfTeds()
                .channel
                .items
                .map {
                    TedObject(
                        it.title,
                        it.description,
                        it.image.url,
                        it.duration.text
                    )
                }
        }
    }
}