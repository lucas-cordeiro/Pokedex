package br.com.lucas.cordeiro.pokedex.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.lucas.cordeiro.pokedex.database.dao.PokemonDao
import br.com.lucas.cordeiro.pokedex.database.entity.PokemonEntity

@Database( entities = [PokemonEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pokemonDao() : PokemonDao
}