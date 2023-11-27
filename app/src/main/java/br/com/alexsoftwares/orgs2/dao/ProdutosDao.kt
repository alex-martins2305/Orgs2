package br.com.alexsoftwares.orgs2.dao

import br.com.alexsoftwares.orgs2.model.Produto

class ProdutosDao {
    fun adicionar(produto:Produto){
        produtos.add(produto)
    }
    fun buscaTodos():List<Produto>{
        return produtos.toList()
    }

    companion object {
        private val produtos= mutableListOf<Produto>()
    }
}