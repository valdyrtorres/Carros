package br.com.roentgen.carros.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.roentgen.carros.R
import br.com.roentgen.carros.domain.TipoCarro
import br.com.roentgen.carros.extensions.addFragment
import br.com.roentgen.carros.extensions.setupToolbar
import br.com.roentgen.carros.fragments.CarrosFragment

class CarrosActivity : BaseActivity() {

    override fun onCreate(icicle: Bundle?) {
        super.onCreate(icicle)
        setContentView(R.layout.activity_carros)

        // Argumentos: tipo do carro
        val tipo = intent.getSerializableExtra("tipo") as TipoCarro
        val title = getString(tipo.string)

        // Toolbar: configura o titulo e o "up navigation"
        setupToolbar(R.id.toolbar, title, true)

        if(icicle == null) {
            // Adiciona o fragment no layout de marcação
            // Dentre os argumentos que foram passados para a activity, está o tipo do carro
            addFragment(R.id.container, CarrosFragment())
        }
    }
}
