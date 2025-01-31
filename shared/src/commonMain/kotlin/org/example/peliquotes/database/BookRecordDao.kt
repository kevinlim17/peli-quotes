package org.example.peliquotes.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import org.example.peliquotes.model.BookRecord

@Dao
interface BookRecordDao {
    /** Create new BookRecord with QuoteRecord */
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createBookRecord(bookRecord: BookRecord)

    @Transaction
    @Query("SELECT * FROM book_record")
    suspend fun readAll(): List<BookRecord>

    @Transaction
    @Query("SELECT * FROM book_record WHERE book_id = :id")
    suspend fun readById(id: Long): BookRecord

    @Transaction
    @Query("SELECT * FROM book_record WHERE genre = :genre")
    suspend fun readByGenre(genre: String): List<BookRecord>

    @Transaction
    @Update
    suspend fun updateBookRecord(bookRecord: BookRecord)

    @Transaction
    @Delete
    suspend fun deleteBookRecord(bookRecord: BookRecord)
}