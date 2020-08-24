package br.com.lucas.cordeiro.pokedex.ui.home.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import br.com.lucas.cordeiro.pokedex.model.Pokemon
import br.com.lucas.cordeiro.pokedex.utils.KLog
import br.com.lucas.cordeiro.pokedex.utils.getTypeColor
import br.com.lucas.cordeiro.pokedex.utils.visible
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_pokemon.view.*

class PokemonListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(pokemon: Pokemon) {
        itemView.txtErrorTitle.visible = false
        itemView.txtErrorSubtitle.visible = false
        itemView.txtType1.visible = false
        itemView.txtType2.visible = false

        val pokemonTypes = pokemon.types?.map { it.type?.name }
        KLog.log("pokemonTypes: ${pokemonTypes}")

        if(!pokemonTypes.isNullOrEmpty()){
            itemView.cardView.setCardBackgroundColor(pokemonTypes[0]!!.getTypeColor(itemView.context))

            itemView.txtType1.text = pokemonTypes[0]!!.capitalize()
            itemView.txtType1.visible = true

            if(pokemonTypes.size > 1){
                itemView.txtType2.text = pokemonTypes[1]!!.capitalize()
                itemView.txtType2.visible = true
            }
        }

        itemView.txtName.text = pokemon.name?.capitalize()
        itemView.txtId.text = "#${pokemon.id?.toString()?.padStart(3,'0')}"

        if(pokemon.imageUrl.isNullOrBlank()){
            itemView.progressBar.visible = false
        }else {
            itemView.progressBar.visible = true
            Picasso.get()
                .load(pokemon.imageUrl)
                .into(itemView.imgPokemon, object : Callback {
                    override fun onSuccess() {
                        itemView.progressBar.visible = false
                    }

                    override fun onError(e: Exception?) {
                        itemView.progressBar.visible = false
                        itemView.txtErrorTitle.visible = true
                        itemView.txtErrorSubtitle.visible = true
                    }
                })
        }
    }
}