package br.com.lucas.cordeiro.pokedex.network.service

import androidx.core.net.toUri
import br.com.lucas.cordeiro.pokedex.model.Pokemon
import br.com.lucas.cordeiro.pokedex.model.ResponsePokemon
import br.com.lucas.cordeiro.pokedex.network.httpclient.AppHttpClient
import br.com.lucas.cordeiro.pokedex.utils.KLog
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class PokemonService(private val appHttpClient: AppHttpClient) {

    suspend fun doGetPokemons() : ResponsePokemon<Pokemon> {
        val response = appHttpClient.httpClient.get<ResponsePokemon<Pokemon>>(pokemonBasePath){
            parameter("offset", 0)
            parameter("limit", 30)
        }
        response.results?.forEach {
            if(it.id==null){
                it.id = it.url?.toUri()?.lastPathSegment?.toInt()
            }
            val pokemon = doGetPokemonById(it.id?:0)
            it.types = pokemon.types
            KLog.log("Id: ${it.id} Types: ${it.types}")
            it.imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${it.id}.png"
        }
        return response
    }

    suspend fun doGetPokemonById(pokemonId: Int) = appHttpClient.httpClient.get<Pokemon>("$pokemonBasePath/$pokemonId").apply {
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png"
    }

    companion object{
        const val pokemonBasePath = "pokemon"
    }
}