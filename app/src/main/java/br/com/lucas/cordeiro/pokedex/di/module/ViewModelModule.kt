package br.com.lucas.cordeiro.pokedex.di.module

import br.com.lucas.cordeiro.pokedex.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}