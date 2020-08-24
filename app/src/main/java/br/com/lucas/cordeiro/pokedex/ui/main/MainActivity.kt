package br.com.lucas.cordeiro.pokedex.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import br.com.lucas.cordeiro.pokedex.R
import br.com.lucas.cordeiro.pokedex.utils.KLog
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenCreated {
            viewModel.pokemons.filter { it != null }.collect {
                KLog.log("ImageUrl: ${it!![0].imageUrl}")
            }
        }
    }
}