package by.a_makarevich.rsschooltask6

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
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

    private val tedService = retrofit.create(TheTedApi::class.java)

    suspend fun getListOfTeds(): List<TedObject> {
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

// ============================XML
interface TheTedApiXML {
    @GET("/themes/rss/id")
    suspend fun getListOfTedsXML(): ApiDataXML
}

object WebAccessXML {
    private val retrofitXML = Retrofit.Builder()
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .baseUrl("https://www.ted.com")
        .build()
    private val tedServiceXML = WebAccessXML.retrofitXML.create(TheTedApiXML::class.java)

    suspend fun getListOfTedsXML(): List<TedObjectXML>? {
        return withContext(Dispatchers.IO) {
            tedServiceXML.getListOfTedsXML()
                .channel
                ?.item
                ?.map {
                    TedObjectXML(
                        it.myTitle,
                        it.myDescription,
                        it.myItunesImage?.urlXml,
                        it.myItunesDuration
                    )
                }
        }
    }
}