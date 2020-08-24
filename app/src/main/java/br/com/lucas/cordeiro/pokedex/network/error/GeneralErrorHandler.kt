package br.com.lucas.cordeiro.pokedex.network.error

import io.ktor.utils.io.errors.IOException
import java.net.UnknownHostException
import java.nio.channels.UnresolvedAddressException

class GeneralErrorHandler  : ErrorHandler {
    override fun getError(throwable: Throwable): ErrorEntity {
        return when(throwable) {
            is UnresolvedAddressException -> ErrorEntity.Network
            is UnknownHostException -> ErrorEntity.Network
            else -> ErrorEntity.Unknown
        }
    }
}