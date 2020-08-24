package br.com.lucas.cordeiro.pokedex.di.module

import br.com.lucas.cordeiro.pokedex.network.error.GeneralErrorHandler
import br.com.lucas.cordeiro.pokedex.network.httpclient.provideAppHttClient
import br.com.lucas.cordeiro.pokedex.network.httpclient.provideBaseHttpClientConfig
import br.com.lucas.cordeiro.pokedex.network.service.PokemonService
import org.koin.dsl.module

val networkModule = module {
    factory { provideBaseHttpClientConfig() }
    single { provideAppHttClient(get()) }
    single { PokemonService(get())}
    single { GeneralErrorHandler()}
}