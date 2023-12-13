package relatorio;

import java.util.ArrayList;
import produto.Produto;

public class RelatorioEstoque implements I_Relatorio {
    private ArrayList<Produto> produtos;

    public RelatorioEstoque(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }
    @Override
    public void relatorioGeral() {
        System.out.println("\nRelatório de Estoque:");
        for (Produto produto : produtos) {
            System.out.printf("Nome do Produto: %s  Descrição: %s   Quantidade em Estoque: %d  Valor Unitário: R$ %.2f  Valor Total em Estoque: R$ %.2f \n",produto.getNomeProduto(),produto.getCategoriaProduto(),produto.getQuantidadeProduto(),produto.getValorProduto(),(produto.getQuantidadeProduto()*produto.getValorProduto()));
        }
        System.out.println();
    }
}
