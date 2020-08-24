package br.com.lucas.cordeiro.pokedex.model

import kotlinx.serialization.Serializable

@Serializable
data class ResponsePokemon<T>(
    var count: Long? = null,
    var next: String? = null,
    var previous: String? = null,
    var results: List<T>? = null
)