package br.com.lucas.cordeiro.pokedex.database.mapper

import br.com.lucas.cordeiro.pokedex.database.entity.PokemonEntity
import br.com.lucas.cordeiro.pokedex.model.Pokemon
import br.com.lucas.cordeiro.pokedex.model.PokemonType
import com.google.gson.Gson

fun PokemonEntity.toModel() : Pokemon {
    val pokemon = Pokemon()
    pokemon.id = id
    pokemon.imageUrl = imageUrl
    pokemon.name = name
    pokemon.url = url
    pokemon.types = if(types!=null){
        val listTypes: MutableList<PokemonType> = ArrayList()
        types?.split("*-*")?.forEach {
            val item = Gson().fromJson(it, PokemonType::class.java)
            if(item!=null)
            listTypes.add(item)
        }
        listTypes
    }else null
    return pokemon
}

fun Pokemon.toDAO() : PokemonEntity {
    val pokemon = PokemonEntity()
    pokemon.id = id
    pokemon.imageUrl = imageUrl
    pokemon.name = name
    pokemon.url = url
    pokemon.types = if(types!=null) {
        val sb = StringBuilder()
        types?.forEachIndexed { index, pokemonType ->
            sb.append(Gson().toJson(pokemonType))
            if(index < types?.size?:0 - 1){
                sb.append("*-*")
            }
        }
        sb.toString()
    } else null
    return pokemon
}