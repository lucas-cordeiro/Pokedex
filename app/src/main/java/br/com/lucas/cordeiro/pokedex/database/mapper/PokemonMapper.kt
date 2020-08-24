package br.com.lucas.cordeiro.pokedex.database.mapper

import br.com.lucas.cordeiro.pokedex.database.entity.PokemonEntity
import br.com.lucas.cordeiro.pokedex.model.Pokemon

fun PokemonEntity.toModel() : Pokemon {
    val pokemon = Pokemon()
    pokemon.id = id
    pokemon.imageUrl = imageUrl
    pokemon.name = name
    pokemon.url = url
    return pokemon
}

fun Pokemon.toDAO() : PokemonEntity {
    val pokemon = PokemonEntity()
    pokemon.id = id
    pokemon.imageUrl = imageUrl
    pokemon.name = name
    pokemon.url = url
    return pokemon
}