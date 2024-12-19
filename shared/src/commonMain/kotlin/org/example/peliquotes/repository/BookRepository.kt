package org.example.peliquotes.repository

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import org.example.peliquotes.model.Book
import org.example.peliquotes.network.BookAPI

class BookRepository(
    private val title: String,
    private val bookAPI: BookAPI,
    private val bookStorage: BookStorage
) {
    private val scope = CoroutineScope(SupervisorJob())

    fun initialize() {
        scope.launch {
            refresh()
        }
    }

    private suspend fun refresh() {
        bookStorage.saveBookObjects(bookAPI.getBookData(title = title))
    }

    fun getBookData(): Flow<List<Book>> = bookStorage.getBookData()
}