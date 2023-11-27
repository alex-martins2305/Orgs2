package br.com.alexsoftwares.orgs2.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.alexsoftwares.orgs2.R
import br.com.alexsoftwares.orgs2.model.Produto
import java.math.BigDecimal


class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)
        botaoSalvar.setOnClickListener {
            val CampoNome = findViewById<TextView>(R.id.nome)
            val nome = CampoNome.text.toString()

            val CampoDescricao = findViewById<TextView>(R.id.descricao)
            val descricao = CampoDescricao.text.toString()

            val CampoValor = findViewById<TextView>(R.id.valor)
            val valorEmTexto = CampoValor.text.toString()
            val valor= if (valorEmTexto.isBlank()||valorEmTexto.equals(" ")) {
                    BigDecimal.ZERO
                } else {
                    BigDecimal.ZERO
        }

            val produto = Produto(
                nome,
                descricao,
                valor
            )

            Log.i("FormularioProduto", "$produto")
        }


    }
}
