package br.com.lucas.cordeiro.pokedex.network.httpclient

import br.com.lucas.cordeiro.pokedex.BuildConfig
import br.com.lucas.cordeiro.pokedex.utils.KLog
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.features.HttpTimeout
import io.ktor.client.features.defaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.request.accept
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import java.util.logging.Level

private val json = Json(JsonConfiguration.Stable.copy(ignoreUnknownKeys = true, encodeDefaults = false, isLenient = true))

fun provideBaseHttpClientConfig() : HttpClientConfig<OkHttpConfig>{
    val config = HttpClientConfig<OkHttpConfig>()
    config.install(JsonFeature){
        serializer = KotlinxSerializer(json)
    }

    config.install(Logging){
        logger = object : Logger {
            override fun log(message: String) {
                KLog.log(message, "KTOR")
            }
        }
        level = if(BuildConfig.DEBUG) LogLevel.ALL else LogLevel.NONE
    }

    config.install(HttpTimeout){
        requestTimeoutMillis = 15000L
        connectTimeoutMillis = 15000L
        socketTimeoutMillis = 15000L
    }

    config.defaultRequest {
        if(method != HttpMethod.Get) contentType(ContentType.Application.Json)
        accept(ContentType.Application.Json)
    }

    return config
}