package br.com.alexsoftwares.orgs2.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.alexsoftwares.orgs2.databinding.ProdutoItemBinding
import br.com.alexsoftwares.orgs2.model.Produto
import com.bumptech.glide.Glide
import java.lang.NumberFormatException
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

class ListaProdutosAdapter (
    private val context: Context,
    produtos:List<Produto>
): RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos=produtos.toMutableList()
    class ViewHolder (private val binding: ProdutoItemBinding):RecyclerView.ViewHolder(binding.root) {

        fun vincula(produto: Produto) {
            val foto=binding.produtoItemFoto
            val fotolink="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtT_Okoy-bdhjWA9QPv1tXdtoRQd7P6rOXEg&usqp=CAU"
            Glide.with(foto).load(fotolink).into(foto)
            val nome = binding.produtoItemNome
            nome.text = produto.nome
            val descricao = binding.produtoItemDescricao
            descricao.text = produto.descricao
            val valor = binding.produtoItemValor
            val valorEmMoeda: String =
                formataParaMoedaBrasileira(produto.valor)
            valor.text = valorEmMoeda
        }
        private fun formataParaMoedaBrasileira(valor: BigDecimal): String {
            val formatador: NumberFormat = NumberFormat
                .getCurrencyInstance(Locale("pt", "br"))
            return formatador.format(valor)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater=LayoutInflater.from(context)
        val binding = ProdutoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }
    override fun getItemCount(): Int =produtos.size

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }

}
