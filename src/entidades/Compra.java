package entidades;
import java.util.ArrayList;
import java.util.Scanner;

import compra.Carrinho;
import pagamento.I_Pagamento;
import pagamento.PagamentoCredito;
import pagamento.PagamentoDebito;
import pagamento.PagamentoDinheiro;
import pagamento.PagamentoPix;
import produto.Produto;
import relatorio.RelatorioCaixa;

public class Compra {
    // Compras 
    public static void compras(Scanner scan,Carrinho carrinho,ArrayList<Produto> produtos,RelatorioCaixa relatorioCaixa){
    boolean validarInfo = false;
    int opcao;
    boolean sair = false;
    while (!sair) {
        try {
            System.out.print("1- Adicionar produto ao carrinho\n2- Finalizar compra\n0- Sair\nOpcao: ");
            opcao = Integer.parseInt(scan.nextLine());
            switch (opcao) {
                case 1: // 1- Adicionar produto ao carrinho
                    System.out.print("Produto a adicionar ao carrinho: ");
                    String compraProduto = scan.nextLine();
                    Produto produtoEncontrado = null;

                    for (Produto produto : produtos) {
                        if (produto.getNomeProduto().equalsIgnoreCase(compraProduto)) {
                            produtoEncontrado = produto;
                            break;
                        }
                    }
                    if (produtoEncontrado != null) {
                        System.out.print("Quantidade do produto: ");
                        validarInfo = false;
                        while (!validarInfo) {
                            try {
                                int quantidade = Integer.parseInt(scan.nextLine());
                                validarInfo = true;
                                if(quantidade <= produtoEncontrado.getQuantidadeProduto()){
                                    produtoEncontrado.retiradaVenda(quantidade);
                                    carrinho.adicionarItem(produtoEncontrado, quantidade);
                                    System.out.println("Produto adicionado ao carrinho.");
                                }else{
                                    System.out.println("Quantia indisponivel no estoque!");
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Valor invalido! Insira um numero valido. ");
                                System.out.print("Quantidade do produto: ");
                            }                      
                        }
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;
                case 2: //2- Finalizar compra
                    double totalCompra = carrinho.calcularTotal();
                    if (totalCompra > 0) {
                        System.out.println("Valor total da compra: R$" + totalCompra);
                        Compra.formaPagamento(scan,totalCompra,relatorioCaixa);
                        totalCompra = carrinho.calcularTotal();
                        Relatorio.totalVendasCaixa += totalCompra;
                        // Adiciona todos itens vendidos ao relatorio de caixa
                        relatorioCaixa.adicionarItensDoCarrinho(carrinho);
                        sair = true;
                    } else {
                        System.out.println("O carrinho está vazio. Adicione produtos antes de finalizar a compra.");
                    }
                    break;

                case 0://0- Sair
                    sair = true;
                    break;

                default: // default 
                    System.out.println("Opção inválida!");
                    break;
            }
        } catch (NumberFormatException e) {
            System.err.println("Por favor, insira um número válido.");
        } 
    }
}
    //validar formas de pagamento 
    public static void formaPagamento(Scanner scan,double valorCompra,RelatorioCaixa relatorioCaixa){
        boolean sair = false;
        int opcao;
        while(!sair){
            try {
                System.out.println("Valor da compra: "+valorCompra+
                                    "\nForma de Pagamento:\n"+
                                    "1- A vista com 10% de desconto\n"+
                                    "2- Debito com 5% de desconto\n"+
                                    "3- Credito sem juros em 2x, acima 3% de juros\n"+
                                    "4- Pix com 10% de desconto\n"+
                                    "Opcao: ");
                opcao = scan.nextInt();
                scan.nextLine();
                switch(opcao){
                    case 1://A Vista
                        // Processando o pagamento dinheiro
                        I_Pagamento pagamentoDinheiro = new PagamentoDinheiro(valorCompra);
                        pagamentoDinheiro.processoPagamento(valorCompra);
                        Relatorio.totalVendasCaixaPag += pagamentoDinheiro.getValorComDesconto();
                        System.out.println(pagamentoDinheiro.toString());
                        sair = true;
                        break;
                    case 2://Debito
                        // Processando o pagamento com cartão de débito
                        I_Pagamento pagamentoDebito = new PagamentoDebito(valorCompra);
                        pagamentoDebito.processoPagamento(valorCompra);
                        Relatorio.totalVendasCaixaPag += pagamentoDebito.getValorComDesconto();
                        System.out.println(pagamentoDebito.toString());
                        sair = true;
                        break;
                    case 3://Credito
                        // Processando o pagamento com cartão de Credito
                        try {
                            System.out.println("Digite o numero de parcelas enntre 1 ate 6 vezes: \nParcelas:");
                            int parcelas = Integer.parseInt(scan.nextLine());
                            I_Pagamento pagamentoCredito= new PagamentoCredito(valorCompra,parcelas);
                            if(parcelas > 0 && parcelas <= 6){
                                // Processando o pagamento com cartão de crédito
                                pagamentoCredito.processoPagamento(valorCompra);
                                Relatorio.totalVendasCaixaPag += pagamentoCredito.getValorComDesconto();
                                System.out.println(pagamentoCredito.toString());
                                sair = true;
                                break;
                            }else{System.out.println("Parcela indisponivel\n");}
                        }catch (NumberFormatException e) {
                            System.err.println("Por favor, insira um número válido.");
                        }
                        break;
                    case 4://Pix 
                        // Processando o pagamento Pix
                        I_Pagamento pagamentoPix= new PagamentoPix(valorCompra);
                        pagamentoPix.processoPagamento(valorCompra);
                        Relatorio.totalVendasCaixaPag += pagamentoPix.getValorComDesconto();
                        System.out.println(pagamentoPix.toString());
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção Invalida!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Por favor, insira um número válido.");
            }
        }
    }
}
