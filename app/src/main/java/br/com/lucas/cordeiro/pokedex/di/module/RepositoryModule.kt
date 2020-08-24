package br.com.lucas.cordeiro.pokedex.di.module

import br.com.lucas.cordeiro.pokedex.repository.PokemonRepository
import org.koin.dsl.module

val repositoryModule = module {
    single{ PokemonRepository(get()) }
}