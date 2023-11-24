package entidades;

import java.util.ArrayList;
import java.util.List;


import produto.Produto;
public class Carrinho {
    private List<CarrinhoCompra> items = new ArrayList<>();
    
    public void adicionarItem(Produto produto, int quantidade) {
        // Verifique se o produto já está no carrinho
        for (CarrinhoCompra item : items) {
            if (item.getProduto().equals(produto)) {
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }
        // Se não estiver, adicione um novo item ao carrinho
        CarrinhoCompra newItem = new CarrinhoCompra(produto, quantidade);
        items.add(newItem);
    }
    // puxar os Itens vendidos para o relatorio de caixa
    public List<CarrinhoCompra> getItensVendidos(){
        return new ArrayList<>(items);
    }
    // Calcula o valor total do carrinho
    public double calcularTotal() {
        double total = 0;
        for (CarrinhoCompra item : items) {
            total += item.getProduto().getValorProduto() * item.getQuantidade();
        }
        
        return total;
    }
}