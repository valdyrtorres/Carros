package br.com.roentgen.carros.domain

/**
 * Created by valdy on 11/03/2018.
 */

import android.util.Base64
import br.com.roentgen.carros.CarrosApplication
import br.com.roentgen.carros.R.string.carros
import java.io.File
import android.content.Context
import br.com.roentgen.carros.R.string.tipo

/**
 * Implementação com OkHttp
 */
object CarroService {
    private val BASE_URL = "http://livrowebservices.com.br/rest/carros"

    // Busca os carros por tipo (clássicos, esportivos ou luxo)
    fun getCarros(context: Context, tipo: TipoCarro): List<Carro> {
        val url = "$BASE_URL/tipo/${tipo.name}"
        val tipoString = context.getString(tipo.string)

        // Cria um array vazio de carros
        val carros = mutableListOf<Carro>()

        // Cria 20 carros
        for (i in 1..20) {
            val c = Carro()
            // Nome do carro dinâmico para brincar
            c.nome = "Carro $tipoString: $i"
            c.desc = "Desc " + i

            // Url da Foto fixa por enquanto
            c.urlFoto = "http://www.livroandroid.com.br/livro/carros/esportivos/Ferrari_FF.png"
            carros.add(c)
        }

        return carros
    }

}