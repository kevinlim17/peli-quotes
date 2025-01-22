package org.example.peliquotes.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import org.example.peliquotes.model.BookResponse

interface AbstractBookStorage {
    suspend fun saveBookObjects(newBookObjects: List<BookResponse>)

    fun getBookData(): Flow<List<BookResponse>>
}

class BookStorage : AbstractBookStorage {
    private val storedBooks = MutableStateFlow(emptyList<BookResponse>())

    override suspend fun saveBookObjects(newBookObjects: List<BookResponse>) {
        storedBooks.value = newBookObjects
    }

    override fun getBookData(): Flow<List<BookResponse>> = storedBooks
}