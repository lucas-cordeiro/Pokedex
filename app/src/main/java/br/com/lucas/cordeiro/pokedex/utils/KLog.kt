package br.com.lucas.cordeiro.pokedex.utils

import android.util.Log

class KLog {
    companion object{
        fun log(message: String?, tag: String = "KLog"){
            Log.d(tag, message?:"null")
        }

        fun log(message: String?, t: Throwable, tag: String = "KLog"){
            Log.d(tag, message?:"null", t)
        }
    }
}