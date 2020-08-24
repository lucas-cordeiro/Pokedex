package br.com.lucas.cordeiro.pokedex.network.error

sealed class ErrorEntity {

    object Network : ErrorEntity()
    object Unknown : ErrorEntity()
}