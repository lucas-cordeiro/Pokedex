package br.com.lucas.cordeiro.pokedex.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonType(
    var slot: Int? = null,
    var type: PokemonSampleData? = null
)