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
            it.imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${it.id}.svg"
        }
        return response
    }

    suspend fun doGetPokemonById(pokemonId: Int) = appHttpClient.httpClient.get<Pokemon>("$pokemonBasePath/$pokemonId").apply {
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/dream-world/${id}.svg"
    }

    companion object{
        const val pokemonBasePath = "pokemon"
    }
}