package br.com.lucas.cordeiro.pokedex.utils

import android.content.Context
import androidx.core.content.ContextCompat
import br.com.lucas.cordeiro.pokedex.R

fun String.getTypeColor(context: Context) : Int{
    val colorId = when(this.toLowerCase()){
        "normal"-> R.color.colorPokemonTypeNormal
        "fire"-> R.color.colorPokemonTypeFire
        "water"-> R.color.colorPokemonTypeWater
        "grass"-> R.color.colorPokemonTypeGrass
        "electric"-> R.color.colorPokemonTypeElectric
        "ice"-> R.color.colorPokemonTypeIce
        "ground"-> R.color.colorPokemonTypeGround
        "flying"-> R.color.colorPokemonTypeFlying
        "poison"-> R.color.colorPokemonTypePoison
        "fighting"-> R.color.colorPokemonTypeFighting
        "psychic"-> R.color.colorPokemonTypePsychic
        "dark"-> R.color.colorPokemonTypeDark
        "rock"-> R.color.colorPokemonTypeRock
        "bug"-> R.color.colorPokemonTypeBug
        "ghost"-> R.color.colorPokemonTypeGhost
        "steel"-> R.color.colorPokemonTypeSteel
        "dragon"-> R.color.colorPokemonTypeDragon
        "fairy"-> R.color.colorPokemonTypeFairy
        else -> R.color.colorPokemonTypeNormal
    }
    return ContextCompat.getColor(context, colorId)
}