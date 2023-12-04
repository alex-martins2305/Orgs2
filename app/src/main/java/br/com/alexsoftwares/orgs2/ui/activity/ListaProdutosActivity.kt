package br.com.alexsoftwares.orgs2.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.alexsoftwares.orgs2.R
import br.com.alexsoftwares.orgs2.dao.ProdutosDao
import br.com.alexsoftwares.orgs2.databinding.ActivityListaProdutosBinding
import br.com.alexsoftwares.orgs2.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityListaProdutosBinding.inflate(layoutInflater)
    }

    private val DAO =ProdutosDao()
    private val adapter=ListaProdutosAdapter(context = this, produtos = DAO.buscaTodos())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView=binding.activityListaProdutoReciclerView
        configuraRecyclerView()
        setContentView(binding.root)
        //Toast.makeText(this, "Hello World Alex", Toast.LENGTH_SHORT).show()
    }
    override fun onResume() {
        super.onResume()
        adapter.atualiza(DAO.buscaTodos())
        configuraFab()
    }

    private fun configuraFab() {
        val fab=binding.activityListaProdutoAddButton
        //val fab = findViewById<FloatingActionButton>(R.id.activity_lista_produto_addButton)
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView=binding.activityListaProdutoReciclerView
        //val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_produto_reciclerView)
        recyclerView.adapter=adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
