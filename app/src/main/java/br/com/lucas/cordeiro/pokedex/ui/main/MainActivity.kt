package br.com.lucas.cordeiro.pokedex.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import br.com.lucas.cordeiro.pokedex.R
import br.com.lucas.cordeiro.pokedex.network.error.ErrorEntity
import br.com.lucas.cordeiro.pokedex.network.error.Result
import br.com.lucas.cordeiro.pokedex.ui.base.BaseActivity
import br.com.lucas.cordeiro.pokedex.utils.KLog
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import org.koin.android.ext.android.inject

class MainActivity : BaseActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenCreated {
            viewModel.pokemons.collect {
                when(it){
                    is Result.Success -> {
                        if(!it.data.isNullOrEmpty()){
                            KLog.log("ImageUrl: ${it.data.get(0).imageUrl}")
                        }
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