package br.com.alexsoftwares.orgs2.ui.activity

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alexsoftwares.orgs2.R
import br.com.alexsoftwares.orgs2.model.Produto
import br.com.alexsoftwares.orgs2.ui.recyclerview.adapter.ListaProdutosAdapter
import java.math.BigDecimal

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Toast.makeText(this, "Hello World Alex", Toast.LENGTH_SHORT).show()
        setContentView(R.layout.activity_main)
//        val nome=findViewById<TextView>(R..nome)
//        nome.text = "Cesta de frutas"
//        val descricao=findViewById<TextView>(id.descricao)
//        descricao.text = "Laranja, manga e uvas"
//        val valor=findViewById<TextView>(id.valor)
//        valor.text = "R$ 19,99"
        val recyclerView = findViewById<RecyclerView>(R.id.reciclerView)
        recyclerView.adapter = ListaProdutosAdapter(
            context = this, produtos = listOf(
                Produto(
                    nome = "teste",
                    descricao = "testeDesc",
                    valor = BigDecimal(19.99)
                ),
                Produto(
                    nome = "teste2",
                    descricao = "testeDesc2",
                    valor = BigDecimal(15.99)
                ),
            )
        )
        recyclerView.layoutManager=LinearLayoutManager(this)
    }
}
