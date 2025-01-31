package org.example.peliquotes.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import org.example.peliquotes.model.BookWithQuotes

@Dao
interface BookWithQuotesDao {
    @Transaction
    @Query("SELECT * FROM book_record WHERE book_id = :bookId")
    suspend fun getBookWithQuotesByBookId(bookId: Long): List<BookWithQuotes>
}