package relatorio;

import java.util.List;
import entidades.CarrinhoCompra;

public class RelatorioCaixa implements I_Relatorio {
    private List<CarrinhoCompra> itensVendidos;
    public RelatorioCaixa(List<CarrinhoCompra> itensVendidos){
        this.itensVendidos = itensVendidos;

    }
    @Override
    public void relatorioGeral() {
        System.out.println("\nRelatório de Caixa:");
        for (CarrinhoCompra item : itensVendidos) {
            System.out.printf("Nome do Produto: %s  Quantidade vendida em Caixa: %d\n",item.getProduto().getNomeProduto(),item.getQuantidade());
        }
        System.out.println();
    }
}