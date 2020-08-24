package br.com.lucas.cordeiro.pokedex.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.lucas.cordeiro.pokedex.database.entity.PokemonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun doInsertAll(list: List<PokemonEntity>)

    @Query("SELECT * FROM pokemon ORDER BY id LIMIT :limit OFFSET :offset")
    fun doGetAll(offset: Int, limit: Int) : Flow<List<PokemonEntity>>
}