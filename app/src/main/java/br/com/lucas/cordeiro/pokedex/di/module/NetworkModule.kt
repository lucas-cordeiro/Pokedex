package br.com.lucas.cordeiro.pokedex.di.module

import br.com.lucas.cordeiro.pokedex.network.httpclient.provideAppHttClient
import br.com.lucas.cordeiro.pokedex.network.httpclient.provideBaseHttpClientConfig
import org.koin.dsl.module

val networkModule = module {
    factory { provideBaseHttpClientConfig() }
    single { provideAppHttClient(get()) }
}