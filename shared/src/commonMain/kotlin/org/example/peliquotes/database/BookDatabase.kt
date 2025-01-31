package org.example.peliquotes.database

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import org.example.peliquotes.model.BookRecord

internal const val BOOK_DATABASE_NAME = "book_record.db"

@Database(entities = [BookRecord::class], version = 1)
@ConstructedBy(BookDatabaseConstructor::class)
abstract class BookDatabase : RoomDatabase() {
    abstract fun bookRecordDao(): BookRecordDao
}

/** Implementation of Actual Object Needed for DI */
@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object BookDatabaseConstructor : RoomDatabaseConstructor<BookDatabase>{
    override fun initialize(): BookDatabase
}
