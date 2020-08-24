package br.com.lucas.cordeiro.pokedex.model

import kotlinx.serialization.Serializable

@Serializable
data class Pokemon(
    var id: Int? = null,
    var name: String? = null,
    var url: String? = null,
    var imageUrl: String? = null
)