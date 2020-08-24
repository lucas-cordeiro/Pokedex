package br.com.lucas.cordeiro.pokedex.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucas.cordeiro.pokedex.model.Pokemon
import br.com.lucas.cordeiro.pokedex.network.error.GeneralErrorHandler
import br.com.lucas.cordeiro.pokedex.network.error.Result
import br.com.lucas.cordeiro.pokedex.repository.PokemonRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainViewModel(private val pokemonRepository: PokemonRepository, private val generalErrorHandler: GeneralErrorHandler) : ViewModel() {
    private val _pokemons = MutableStateFlow<Result<List<Pokemon>>?>(null)
    val pokemons: StateFlow<Result<List<Pokemon>>?>
        get() = _pokemons

    init {
        viewModelScope.launch {
            pokemonRepository.doGetPokemons()
                .catch {
                    _pokemons.value = Result.Error(generalErrorHandler.getError(it))
                }
                .collect {
                    _pokemons.value = Result.Success(it)
                }
        }
    }
}