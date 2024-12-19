package org.example.peliquotes.model

import kotlinx.serialization.Serializable

@Serializable
data class Book (
    /** Quote를 찾는 Key = Quote bookId */
    val id : Int,
    val imageURI : String,
    val title : String,
    val author : String,
    val translator : String?,
    val publisher : String,
    val publishYear : Int,
    val genre : String,
    /** 최초 기록한 날짜 */
    val firstAdded : String?,
    val color : String?, // 별도 Class 작성할 수 있음
)

