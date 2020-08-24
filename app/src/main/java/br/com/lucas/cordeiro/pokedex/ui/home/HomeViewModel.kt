package br.com.lucas.cordeiro.pokedex.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucas.cordeiro.pokedex.model.Pokemon
import br.com.lucas.cordeiro.pokedex.network.error.GeneralErrorHandler
import br.com.lucas.cordeiro.pokedex.network.error.Result
import br.com.lucas.cordeiro.pokedex.repository.PokemonRepository
import br.com.lucas.cordeiro.pokedex.utils.KLog
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(private val pokemonRepository: PokemonRepository, private val generalErrorHandler: GeneralErrorHandler) : ViewModel() {
    private val _pokemons = MutableStateFlow<Result<List<Pokemon>>?>(null)
    val pokemons: StateFlow<Result<List<Pokemon>>?>
        get() = _pokemons

    init {
        viewModelScope.launch {

            pokemonRepository.doGetPokemons()
                .catch {
                    KLog.log("Error doGetPokemons", it)
                    _pokemons.value = Result.Error(generalErrorHandler.getError(it))
                }
                .onEach {
                    _pokemons.value = Result.Success(it)
                }.launchIn(this)

            pokemonRepository.doRefreshPokemonsData()
        }
    }
}