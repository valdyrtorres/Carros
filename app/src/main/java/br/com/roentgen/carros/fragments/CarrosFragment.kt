package br.com.roentgen.carros.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.roentgen.carros.R
import br.com.roentgen.carros.activity.CarroActivity
import br.com.roentgen.carros.activity.CarrosActivity
import br.com.roentgen.carros.adapter.CarroAdapter
import br.com.roentgen.carros.domain.Carro
import br.com.roentgen.carros.domain.CarroService
import br.com.roentgen.carros.domain.TipoCarro
import br.com.roentgen.carros.extensions.toast
import kotlinx.android.synthetic.main.fragment_carros.*
import org.jetbrains.anko.startActivity

class CarrosFragment : BaseFragment() {

    private var tipo: TipoCarro = TipoCarro.classicos
    private var carros = listOf<Carro>()

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)

        // Lê o parâmetro tipo enviado (clássicos, esportivos ou luxo)
        tipo = arguments.getSerializable("tipo") as TipoCarro
    }

    // Cria a view do fragment
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              icicle: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_carros, container, false)
        return view
    }

    override fun onViewCreated(view: View?, icicle: Bundle?) {
        super.onViewCreated(view, icicle)

        // Views
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.setHasFixedSize(true)
    }

    override fun onResume() {
        super.onResume()
        taskCarros()
    }

    fun taskCarros() {
        // Busca os carros
        this.carros = CarroService.getCarros(context, tipo)

        // Atualiza a lista
        recyclerView.adapter = CarroAdapter(carros) { onClickCarro(it) }
    }

    fun onClickCarro(carro: Carro) {
        // Ao clicar no carro vamos navegar para a tela de detalhes
        activity.startActivity<CarroActivity>("carro" to carro)
    }
}
