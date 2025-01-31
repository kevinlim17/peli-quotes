package org.example.peliquotes.model

import androidx.room.Embedded
import androidx.room.Relation

data class BookWithQuotes(
    @Embedded val bookRecord: BookRecord,
    @Relation(
        parentColumn = "book_id",
        entityColumn = "book_record_id"
    ) val quoteRecord: List<QuoteRecord>
)
