package org.example.peliquotes.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "quote_record")
@Serializable
data class QuoteRecord(
    /** BookRecord의 Primary Key */
    @ColumnInfo(name = "book_record_id")
    val bookRecordId: Long?,
    /** Primary Key */
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "quote_id")
    val quoteId: Long,
    /** Page 정보를 가지고 있는 쌍 */
    @Embedded
    val pages: Pair<Int, Int?>,
    val content: String,
    /** 출처 포매팅 및 출력 함수 작성 필요*/
    val quotation: String?
){
    fun pagesPairToString(): String {
        return if (pages.second == null) {
            "p. ${pages.first}"
        } else {
            "pp. ${pages.first} - ${pages.second}"
        }
    }
}