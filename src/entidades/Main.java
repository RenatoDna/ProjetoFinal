package entidades;

import java.util.Scanner;
import compra.Carrinho;


public class Main {
    private static Scanner scan = new Scanner(System.in);
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
                        Program.cadastroProduto();
                        break;
                    case 2://2- Opçao de Compra
                        Program.compras(carrinho);
                        break;
                    case 3:// - Relatoriosz
                        Program.relarotioGeral();
                        break;
                    case 0://Saindo do programa
                        System.exit(0);
                        scan.close();
                    default://Opção inválida
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.err.println("Por favor, insira um número válido.");
            }
        }
    }
    
}
