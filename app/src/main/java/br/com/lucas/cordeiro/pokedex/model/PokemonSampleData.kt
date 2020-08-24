package br.com.lucas.cordeiro.pokedex.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonSampleData(
    var name: String? = null,
    var url: String? = null
)