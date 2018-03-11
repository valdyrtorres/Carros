package br.com.roentgen.carros.domain

/**
 * Created by valdy on 11/03/2018.
 */
import br.com.roentgen.carros.R

enum class TipoCarro(val string: Int) {
    classicos(R.string.classicos),
    esportivos(R.string.esportivos),
    luxo(R.string.luxo)
}