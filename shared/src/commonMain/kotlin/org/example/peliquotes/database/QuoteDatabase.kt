package org.example.peliquotes.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import org.example.peliquotes.model.QuoteRecord

@Database(entities = [QuoteRecord::class], version = 1)
@ConstructedBy(QuoteDatabaseConstructor::class)
abstract class QuoteDatabase : RoomDatabase() {
    abstract fun quoteRecordDao(): QuoteRecordDao
}

/** Implementation of Actual Object Needed for DI */
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object QuoteDatabaseConstructor : RoomDatabaseConstructor<BookDatabase> {
    override fun initialize(): BookDatabase
}


