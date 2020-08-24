package br.com.lucas.cordeiro.pokedex.repository

import br.com.lucas.cordeiro.pokedex.database.dao.PokemonDao
import br.com.lucas.cordeiro.pokedex.database.mapper.toDAO
import br.com.lucas.cordeiro.pokedex.database.mapper.toModel
import br.com.lucas.cordeiro.pokedex.model.Pokemon
import br.com.lucas.cordeiro.pokedex.network.service.PokemonService
import kotlinx.coroutines.flow.*

class PokemonRepository(
    private val pokemonService: PokemonService,
    private val pokemonDao: PokemonDao
) {
    suspend fun doGetPokemonsFromNetwork() = pokemonService.doGetPokemons().results

    suspend fun doGetPokemons() = flow{
        doRefreshPokemonsData()
        emitAll(pokemonDao.doGetAll(0, 30).map { it.map { it.toModel() } })
    }

    private suspend fun doRefreshPokemonsData(){
        val pokemons = doGetPokemonsFromNetwork()
        pokemons?.let {
            pokemonDao.doInsertAll(it.map { it.toDAO() })
        }
    }

    suspend fun doGetPokemonById(pokemonId: Int) = pokemonService.doGetPokemonById(pokemonId)
}