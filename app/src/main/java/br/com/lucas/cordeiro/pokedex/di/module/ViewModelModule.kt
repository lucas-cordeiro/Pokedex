package br.com.lucas.cordeiro.pokedex.di.module

import br.com.lucas.cordeiro.pokedex.ui.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        HomeViewModel(
            get(),
            get()
        )
    }
}