package br.com.lucas.cordeiro.pokedex.network.httpclient

import br.com.lucas.cordeiro.pokedex.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.engine.okhttp.OkHttpConfig
import io.ktor.client.features.defaultRequest
import io.ktor.client.request.url

class AppHttpClient(val httpClient: HttpClient)

fun provideAppHttClient(httpClientConfig: HttpClientConfig<OkHttpConfig>) : AppHttpClient {
    return AppHttpClient(HttpClient(OkHttp){
        plusAssign(httpClientConfig)
        defaultRequest {
            url(scheme = "https", host = BuildConfig.BASE_URL, path = this.url.encodedPath)
        }
    })
}