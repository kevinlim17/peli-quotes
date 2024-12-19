package org.example.peliquotes.model

data class Quote (
    /** Book DB에서 Quote를 찾는 Key*/
    val bookId : Int,
    /** Main Key */
    val quoteId : Int,
    /** Page 정보를 가지고 있는 쌍 */
    val pages : Pair<Int, Int?>,
    /** LargeText 관련 Class로 변경될 수 있음 */
    val content : String,
    val quotation : String?
)

