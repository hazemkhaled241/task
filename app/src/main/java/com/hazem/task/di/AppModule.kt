package com.hazem.task.di

import com.hazem.task.data.remote.KtorClient
import com.hazem.task.data.remote.repository.RecipesRepositoryImp
import com.hazem.task.domain.repository.RecipesRepository
import com.hazem.task.domain.use_case.GetAllRecipesUseCase
import com.hazem.task.presentation.recipes.view_model.RecipesViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {


    single {
        KtorClient(
            client = HttpClient(OkHttp) {
                install(Logging) {
                    level = LogLevel.ALL
                }
                install(ContentNegotiation) {
                    json(Json {
                        ignoreUnknownKeys = true

                    })
                }
            }
                )
    }
    single<RecipesRepository> {
        RecipesRepositoryImp(
            get()
        )


    }
    single {
        GetAllRecipesUseCase(get())
    }
    viewModel {
        RecipesViewModel(get())
    }
}