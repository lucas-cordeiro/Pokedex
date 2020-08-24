package br.com.lucas.cordeiro.pokedex.di.module

import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.lucas.cordeiro.pokedex.database.AppDatabase
import br.com.lucas.cordeiro.pokedex.database.dao.PokemonDao
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "br.com.lucas.cordeiro.pokedex.database"
        ).build()
    }
    single { get<AppDatabase>().pokemonDao()}
}