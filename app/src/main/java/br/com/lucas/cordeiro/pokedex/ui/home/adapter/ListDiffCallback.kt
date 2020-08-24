package br.com.lucas.cordeiro.pokedex.ui.home.adapter

import androidx.recyclerview.widget.DiffUtil
import br.com.lucas.cordeiro.pokedex.model.Pokemon

class PokemonListDiffCallback (
    private val oldList: List<Pokemon>,
    private val newList: List<Pokemon>
) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id==newList[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return true
    }
}