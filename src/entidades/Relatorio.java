package entidades;
import java.util.ArrayList;
import java.util.Scanner;

import produto.Produto;
import relatorio.*;

public class Relatorio {
    //relatorio geral do estoque - quantia ate o momento e relatorio parcial de caixa e total de itens vendidos
    public static double totalVendasCaixaPag=0.0;
    public static double totalVendasCaixa=0.0;
    public static void relarotioGeral(Scanner scan,RelatorioCaixa relatorioCaixa,ArrayList<Produto> produtos ) {
        int opcao;
        boolean sair = false;
        try {
            while (!sair) {
                System.out.println("1- Relatorio Caixa Parcial\n2- Relatorio Estoque\n3- Relatorio de Caixa Completo\n0- Sair\nOpção: ");
                opcao = Integer.parseInt(scan.nextLine());
                switch (opcao) {
                    case 1: // Relatório Caixa Parcial
                        System.out.println("Relatorio de Caixa:\n");
                        Relatorio.relatorioCaixaValor();
                        break;
                    case 2: // Relatório Estoque
                        I_Relatorio relatorioEstoque = new RelatorioEstoque(produtos);
                        relatorioEstoque.relatorioGeral();
                        break;
                    case 3: // Relatorio completo de caixa
                        relatorioCaixa.gerarRelatorio();
                        Relatorio.relatorioCaixaValor();
                        break;
                    case 0:
                        sair = true;
                        break;
                    default:
                        break;
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Por favor, insira um número válido.");
        } 
    }
    // relatorio quantia valor vendido com e sem desconto
    public static void relatorioCaixaValor(){
        System.out.printf("Total de Venda Com Desconto: %.2f \nTotal de Venda Bruto sem descontos aplicados: %.2f \nValor total desconto aplicado: %.2f\n\n",totalVendasCaixaPag,totalVendasCaixa,(totalVendasCaixa-totalVendasCaixaPag));
    }
}
