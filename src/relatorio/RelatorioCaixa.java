package relatorio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import compra.Carrinho;
import compra.CarrinhoCompra;
import produto.Produto;

public class RelatorioCaixa {
    private List<CarrinhoCompra> itensVendidos;
    public RelatorioCaixa() {
        this.itensVendidos = new ArrayList<>();
    }
    public void adicionarItensDoCarrinho(Carrinho carrinho) {
        itensVendidos.addAll(carrinho.getItensVendidos());
    }
    public double calcularTotal() {
        double total = 0;
        for (CarrinhoCompra item : itensVendidos) {
            total += item.getProduto().getValorProduto() * item.getQuantidade();
        }
        return total;
    }
    // relatorio geral de caixa
    public void gerarRelatorio() {
        System.out.println("Relatório de Itens Vendidos:");
        Map<Produto,Integer> quantidadePorProduto = new HashMap<>();
        for(CarrinhoCompra item : itensVendidos){
            Produto produto = item.getProduto();
            int quantidade = item.getQuantidade();
            quantidadePorProduto.put(produto,quantidadePorProduto.getOrDefault(produto,0)+quantidade);
        }
        for (Map.Entry<Produto,Integer> entry : quantidadePorProduto.entrySet()) {
            Produto produto = entry.getKey();
            int quantidadeTotal = entry.getValue();
            double valorTotal = produto.getValorProduto()*quantidadeTotal;
            System.out.printf("Nome do Produto: %s  Quantidade vendida: %d  Valor produto individual R$ %.2f  Valor Total de vendas R$ %.2f\n",produto.getNomeProduto(),quantidadeTotal,produto.getValorProduto(),valorTotal);
        }
        System.out.println();
    }
    
}