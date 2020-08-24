package br.com.lucas.cordeiro.pokedex.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import br.com.lucas.cordeiro.pokedex.R
import br.com.lucas.cordeiro.pokedex.model.Pokemon

class PokemonListAdapter : RecyclerView.Adapter<PokemonListItemViewHolder>() {

    var pokemons = emptyList<Pokemon>()
        set(value) {
            val result = DiffUtil.calculateDiff(
                PokemonListDiffCallback(
                    field,
                    value
                )
            )
            result.dispatchUpdatesTo(this)
            field = value
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonListItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_pokemon, parent, false)

        return PokemonListItemViewHolder(
            view
        )
    }

    override fun onBindViewHolder(holder: PokemonListItemViewHolder, position: Int) {
        holder.bind(pokemons[position])
    }

    override fun getItemCount(): Int = pokemons.size

    override fun getItemId(position: Int): Long {
        return (pokemons[position].id?:0).toLong()
    }
}