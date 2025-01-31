package org.example.peliquotes.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import org.example.peliquotes.model.QuoteRecord

@Dao
interface QuoteRecordDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createQuoteRecord(quoteRecord: QuoteRecord)

    @Update
    suspend fun updateQuoteRecord(quoteRecord: QuoteRecord)

    @Delete
    suspend fun deleteQuoteRecord(quoteRecord: QuoteRecord)
}