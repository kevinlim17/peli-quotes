package org.example.peliquotes.di

import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.example.peliquotes.network.BookAPI
import org.example.peliquotes.network.KtorBookAPI
import org.example.peliquotes.repository.AbstractBookStorage
import org.example.peliquotes.repository.BookRepository
import org.example.peliquotes.repository.BookStorage
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

val bookDataModule = module {
    single {
        val json = Json { ignoreUnknownKeys = true }
        HttpClient {
            install(ContentNegotiation) {
                json(json, contentType = io.ktor.http.ContentType.Application.Json)
            }
        }
    }

    single<BookAPI> { KtorBookAPI(get()) }
    single<AbstractBookStorage> { BookStorage() }
    single {
        BookRepository(get(), get(), get()).apply {
            initialize()
        }
    }
}

fun initKoin() = initKoin(emptyList())

fun initKoin(additionalModules: List<Module>) {
    startKoin {
        modules(
            bookDataModule,
            *additionalModules.toTypedArray()
        )
    }
}
