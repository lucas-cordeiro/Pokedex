package br.com.lucas.cordeiro.pokedex.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucas.cordeiro.pokedex.model.Pokemon
import br.com.lucas.cordeiro.pokedex.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val pokemonRepository: PokemonRepository) : ViewModel() {
    private val _pokemons = MutableStateFlow<List<Pokemon>?>(null)
    val pokemons: StateFlow<List<Pokemon>?>
        get() = _pokemons

    init {
        viewModelScope.launch {
            _pokemons.value = pokemonRepository.doGetPokemons()
        }
    }
}