package br.com.lucas.cordeiro.pokedex.ui.base

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(contentLayoutId: Int) : AppCompatActivity(contentLayoutId) {

    fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}