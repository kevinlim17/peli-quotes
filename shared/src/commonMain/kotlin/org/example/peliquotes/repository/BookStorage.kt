package org.example.peliquotes.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.example.peliquotes.model.Book

interface AbstractBookStorage {
    suspend fun saveBookObjects(newBookObjects: List<Book>)

    fun getBookData(): Flow<List<Book>>
}

class BookStorage : AbstractBookStorage {
    private val storedBooks = MutableStateFlow(emptyList<Book>())

    override suspend fun saveBookObjects(newBookObjects: List<Book>) {
        storedBooks.value = newBookObjects
    }

    override fun getBookData(): Flow<List<Book>> = storedBooks
}