package by.a_makarevich.rsschooltask6

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiData(
    @Json(name = "version") val version: String?,
    @Json(name = "channel") val channel: Channel
)
@JsonClass(generateAdapter = true)
data class Channel(
    @Json(name = "item") val items: List<MyItem>
)
@JsonClass(generateAdapter = true)
data class MyItem(
    @Json(name = "title") val title: String?,
    @Json(name = "description") val description: String?,
    @Json(name = "image") val image: Image,
    @Json(name = "duration") val duration: Duration
)
@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "url") val url: String?
)
@JsonClass(generateAdapter = true)
data class Duration(
    @Json(name = "text") val text: String?
)