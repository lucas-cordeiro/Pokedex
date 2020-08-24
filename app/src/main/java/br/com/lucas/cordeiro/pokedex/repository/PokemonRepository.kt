package br.com.lucas.cordeiro.pokedex.repository

import br.com.lucas.cordeiro.pokedex.network.service.PokemonService

class PokemonRepository(private val pokemonService: PokemonService) {
    suspend fun doGetPokemons() = pokemonService.doGetPokemons().results
    suspend fun doGetPokemonById(pokemonId: Int) = pokemonService.doGetPokemonById(pokemonId)
}