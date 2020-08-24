package br.com.lucas.cordeiro.pokedex.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import br.com.lucas.cordeiro.pokedex.R
import br.com.lucas.cordeiro.pokedex.network.httpclient.AppHttpClient
import io.ktor.client.request.get
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val appHttpClient: AppHttpClient by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenCreated {
            appHttpClient.httpClient.get("pokemon")
        }
    }
}