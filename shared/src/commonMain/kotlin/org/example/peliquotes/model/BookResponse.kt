package org.example.peliquotes.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookResponse(
    @SerialName("image_uri")
    val imageURI: String,
    @SerialName("title")
    val title: String,
    @SerialName("author")
    val author: String,
    @SerialName("translator")
    val translator: String?,
    @SerialName("publisher")
    val publisher: String,
    @SerialName("publish_year")
    val publishYear: Int,
    @SerialName("genre")
    val genre: String
)

