package org.example.peliquotes.network

import org.example.peliquotes.model.BookResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.util.network.UnresolvedAddressException
import kotlinx.serialization.SerializationException
import org.example.peliquotes.BuildKonfig.BASE_URL
import org.example.peliquotes.util.NetworkError
import org.example.peliquotes.util.NetworkResult

interface BookSearchAPI {
    suspend fun getSearchData(title: String): NetworkResult<List<BookResponse>, NetworkError>
}

class KtorBookSearchAPI(private val client: HttpClient) : BookSearchAPI {
    override suspend fun getSearchData(title: String): NetworkResult<List<BookResponse>, NetworkError> {
        val response = try {
            client.get("${BASE_URL}/book") {
                url {
                    parameters.append("book_name", title)
                    parameters.append("n", "5")
                }
            }
        } catch (e: UnresolvedAddressException) {
            return NetworkResult.Error(NetworkError.NO_INTERNET)
        } catch (e: SerializationException) {
            return NetworkResult.Error(NetworkError.SERIALIZATION_ERROR)
        }

        return when(response.status.value) {
            in 200..299 -> NetworkResult.Success(response.body())
            401 -> NetworkResult.Error(NetworkError.UNAUTHORIZED)
            408 -> NetworkResult.Error(NetworkError.REQUEST_FAILED)
            409 -> NetworkResult.Error(NetworkError.CONFLICT)
            413 -> NetworkResult.Error(NetworkError.PAYLOAD_TOO_LARGE)
            in 500..599 -> NetworkResult.Error(NetworkError.SERVER_ERROR)
            else -> NetworkResult.Error(NetworkError.UNKNOWN)
        }
    }
}

