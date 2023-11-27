package br.com.alexsoftwares.orgs2.model

import java.math.BigDecimal

data class Produto(
    val nome: String,
    val descricao: String,
    val valor: BigDecimal
) {
    override fun toString(): String {
        val valorMoney=String.format("%.2f", valor)
        return "$nome\nFrutas: $descricao\nValor: R$ $valorMoney"
            }
}
