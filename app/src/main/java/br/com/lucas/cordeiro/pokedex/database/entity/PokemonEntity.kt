package br.com.lucas.cordeiro.pokedex.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class PokemonEntity(
    @PrimaryKey
    var id: Int? = null,
    @ColumnInfo(name = "name")
    var name: String? = null,
    var url: String? = null,
    var imageUrl: String? = null
)