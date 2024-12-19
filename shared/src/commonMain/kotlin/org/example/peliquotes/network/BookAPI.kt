package org.example.peliquotes.network

import org.example.peliquotes.model.Book
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlin.coroutines.cancellation.CancellationException

interface BookAPI {
    suspend fun getBookData(title: String): List<Book>
}

class KtorBookAPI(private val client: HttpClient) : BookAPI {
    override suspend fun getBookData(title: String): List<Book> {
        return try {
            client.get("${BASE_URL}/book"){
                url {
                    parameters.append("book_name", title)
                    parameters.append("n", "5")
                }
            }.body()
        } catch (e: Exception) {
            if (e is CancellationException) throw e
            e.printStackTrace()
            emptyList()
        }
    }

    companion object {
        private const val BASE_URL = "https://otterious.com/book"
    }
}

