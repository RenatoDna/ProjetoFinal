package entidades;
import java.util.ArrayList;
import java.util.Scanner;
import compra.Carrinho;
import produto.Produto;
import relatorio.RelatorioCaixa;


public class Main {
    private static Scanner scan = new Scanner(System.in);

    private static RelatorioCaixa relatorioCaixa = new RelatorioCaixa();
    private static ArrayList<Produto> produtos = new ArrayList<>();
    public static void main(String[] args) {
        while (true) {
            Carrinho carrinho = new Carrinho();
            System.out.println("Selecione uma opção:"
                                +"\n1- Produto"
                                +"\n2- Compras"
                                +"\n3- Relatorios"
                                +"\n0- Sair\nOpção: ");
            try {
                int opcao = Integer.parseInt(scan.nextLine());
                switch (opcao) {
                    case 1://1- opcao de cadastro de Produto e atualização de dados
                        Program.cadastroProduto(scan,produtos);
                        break;
                    case 2://2- Opçao de Compra
                        Compra.compras(scan,carrinho,produtos,relatorioCaixa);
                        break;
                    case 3:// - Relatoriosz
                        Relatorio.relarotioGeral(scan,relatorioCaixa,produtos);
                        break;
                    case 0://Saindo do programa
                        scan.close();
                        System.exit(0);
                    default://Opção inválida
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Por favor, insira um número válido.");
            } 
        }
    }
    
}
