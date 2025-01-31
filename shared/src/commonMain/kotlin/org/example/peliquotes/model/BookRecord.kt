package org.example.peliquotes.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "book_record")
@Serializable
data class BookRecord(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "book_id")
    val bookId: Long,
    @ColumnInfo(name = "image_uri")
    val imageURI: String?,
    val title: String,
    val author: String,
    val translator: String?,
    @ColumnInfo(name = "publisher")
    val publisher: String,
    @ColumnInfo(name = "publish_year")
    val publishYear: Int,
    @ColumnInfo(name = "genre")
    val genre: String,
    @ColumnInfo(name = "first_added")
    val firstAdded: String?,
    val color: String?
)
