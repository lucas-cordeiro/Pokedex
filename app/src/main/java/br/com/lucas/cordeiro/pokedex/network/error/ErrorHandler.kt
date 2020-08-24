package br.com.lucas.cordeiro.pokedex.network.error

interface ErrorHandler {
    fun getError(throwable: Throwable): ErrorEntity
}