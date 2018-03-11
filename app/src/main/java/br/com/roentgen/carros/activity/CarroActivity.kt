package br.com.roentgen.carros.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.roentgen.carros.R
import br.com.roentgen.carros.domain.Carro
import br.com.roentgen.carros.extensions.loadUrl
import br.com.roentgen.carros.extensions.setupToolbar
import kotlinx.android.synthetic.main.activity_carro_contents.*

class CarroActivity : BaseActivity() {
    val carro by lazy { intent.getParcelableExtra<Carro>("carro") }

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.activity_carro)

        // Seta o nome do carro como título da Toolbar
        setupToolbar(R.id.toolbar, carro?.nome, true)

        // Atualiza os dados do carro na tela
        initViews()
    }

    fun initViews() {
        // Variáveis geradas automaticamente pelo Kotlin Extensions (veja import)
        tDesc.text = carro.desc
        img.loadUrl(carro.urlFoto)
    }
}
