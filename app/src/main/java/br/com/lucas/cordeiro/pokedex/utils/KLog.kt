package br.com.lucas.cordeiro.pokedex.utils

import android.util.Log

class KLog {
    companion object{
        private const val maxLogSize = 1000
        fun log(message: String?, tag: String = "KLog"){
            if(message!=null) {
                for (i in 0..message.length / maxLogSize) {
                    val start = i * maxLogSize
                    var end = (i + 1) * maxLogSize
                    end = if (end > message.length) message.length else end
                    Log.d(tag, message.substring(start, end))
                }
            }else{
                Log.d(tag, "null")
            }
        }

        fun log(message: String?, t: Throwable, tag: String = "KLog"){
            if(message!=null) {
                for (i in 0..message.length / maxLogSize) {
                    val start = i * maxLogSize
                    var end = (i + 1) * maxLogSize
                    end = if (end > message.length) message.length else end
                    Log.d(tag, message.substring(start, end), t)
                }
            }else{
                Log.d(tag, "null", t)
            }
        }
    }
}