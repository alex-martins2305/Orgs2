package br.com.alexsoftwares.orgs2.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.com.alexsoftwares.orgs2.R
import br.com.alexsoftwares.orgs2.model.Produto
import br.com.alexsoftwares.orgs2.dao.ProdutosDao
import java.math.BigDecimal

class FormularioProdutoActivity : AppCompatActivity(R.layout.activity_formulario_produto) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraBotaoSalvar()
    }

    private fun configuraBotaoSalvar() {
        val botaoSalvar = findViewById<Button>(R.id.botao_salvar)
        val DAO = ProdutosDao()
        botaoSalvar.setOnClickListener {
            val produto=criaProduto()
            DAO.adicionar(produto)
            finish()
        }
    }

    private fun criaProduto(): Produto {
        val CampoNome = findViewById<TextView>(R.id.produto_item_nome)
        val nome = CampoNome.text.toString()

        val CampoDescricao = findViewById<TextView>(R.id.produto_item_descricao)
        val descricao = CampoDescricao.text.toString()

        val CampoValor = findViewById<TextView>(R.id.produto_item_valor)
        val valorEmTexto = CampoValor.text.toString()

        val valor = if (valorEmTexto.isBlank() || valorEmTexto.equals(" ")) {
            BigDecimal.ZERO
        } else {
            BigDecimal(valorEmTexto)
        }

        return Produto(
            nome,
            descricao,
            valor
        )
    }
}
