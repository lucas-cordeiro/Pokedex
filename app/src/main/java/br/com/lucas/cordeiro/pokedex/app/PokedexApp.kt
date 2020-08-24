package br.com.lucas.cordeiro.pokedex.app

import android.app.Application
import br.com.lucas.cordeiro.pokedex.di.module.networkModule
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
        networkModule
    )
}