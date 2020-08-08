package by.a_makarevich.rsschooltask6

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class ApiDataXML constructor(
    @field:Element(name = "channel") var channel: ChannelXML? = null
)

@Root(name = "channel", strict = false)
data class ChannelXML constructor(
    @field:ElementList(name = "item", inline = true, required = false)
    var item: List<ItemXML>? = null
)
@Root(name = "item", strict = false)
data class ItemXML constructor(
    @field:Element(name = "title") var myTitle: String? = "",
    @field:Element(name = "description") var myDescription: String? = "",
    @field:Element(name = "image") var myItunesImage: ItunesImage? = null,
    @field:Element(name = "duration") var myItunesDuration: String? = ""
)
@Root(name = "image", strict = false)
data class ItunesImage constructor(
    @field:Attribute(name = "url") var urlXml: String? = ""
)