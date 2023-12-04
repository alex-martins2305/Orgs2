package br.com.alexsoftwares.orgs2.model

import java.math.BigDecimal

data class Produto(
    val foto:String,
    val nome: String,
    val descricao: String,
    val valor: BigDecimal
)
