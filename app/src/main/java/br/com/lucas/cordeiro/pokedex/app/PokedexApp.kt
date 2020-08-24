package br.com.lucas.cordeiro.pokedex.app

import android.app.Application
import br.com.lucas.cordeiro.pokedex.di.module.databaseModule
import br.com.lucas.cordeiro.pokedex.di.module.networkModule
import br.com.lucas.cordeiro.pokedex.di.module.repositoryModule
import br.com.lucas.cordeiro.pokedex.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PokedexApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@PokedexApp)
            modules(provideModules())
        }
    }

    private fun provideModules() = listOf(
        networkModule,
        repositoryModule,
        viewModelModule,
        databaseModule
    )
}