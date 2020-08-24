package br.com.lucas.cordeiro.pokedex.ui.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import br.com.lucas.cordeiro.pokedex.R
import br.com.lucas.cordeiro.pokedex.network.error.ErrorEntity
import br.com.lucas.cordeiro.pokedex.network.error.Result
import br.com.lucas.cordeiro.pokedex.ui.base.BaseFragment
import br.com.lucas.cordeiro.pokedex.ui.home.adapter.PokemonListAdapter
import br.com.lucas.cordeiro.pokedex.utils.KLog
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.inject


class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private val viewModel : HomeViewModel by inject()

    private val adapter by lazy {
        PokemonListAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp(){
        recyclerView.adapter = adapter
        lifecycleScope.launchWhenCreated {
            viewModel.pokemons.collect {
                when(it){
                    is Result.Success -> {
                        adapter.pokemons = it.data
                    }
                    is Result.Error -> {
                        when(it.error){
                            is ErrorEntity.Network -> showToast("Não foi possível conectar com o servidor, verifique sua conexão")
                            is ErrorEntity.Unknown -> showToast("Ocorreu um erro ao tentar listar os pokemons, tente novamente")
                        }
                    }
                }
            }
        }
    }
}