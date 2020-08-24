package br.com.lucas.cordeiro.pokedex.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.lucas.cordeiro.pokedex.R

abstract class BaseFragment(private val contentLayoutId: Int) : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(contentLayoutId, container, false)
    }

    fun showToast(message: String){
        context?.run {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}