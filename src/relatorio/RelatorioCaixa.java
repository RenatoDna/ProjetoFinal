package relatorio;
import java.util.ArrayList;
import java.util.List;

import entidades.Carrinho;
import entidades.CarrinhoCompra;

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
        for (CarrinhoCompra item : itensVendidos) {
            System.out.printf("Nome do Produto: %s  Quantidade vendida: %d  Valor produto individual R$ %.2f  Valor Total de vendas R$ %.2f\n",item.getProduto().getNomeProduto(), item.getQuantidade(), item.getProduto().getValorProduto(),(item.getProduto().getValorProduto() * item.getQuantidade()));
        }
        System.out.println();
    }
    
}