package entidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import pagamento.*;
import produto.*;
import relatorio.*;

public class Main {
    private static ArrayList<Produto> produtos = new ArrayList<>();
    
    private static double totalVendasCaixaPag=0.0;
    private static double totalVendasCaixa=0.0;
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            System.out.println("Selecione uma opção:"
                                +"\n1- Produto"
                                +"\n2- Compras"
                                +"\n3- Relatorios"
                                +"\n0- Sair\nOpção: ");
            try {
                int opcao = Integer.parseInt(scan.nextLine());
                switch (opcao) {
                    case 1://1- opcao de cadastro de Produto e atualização de dados
                        Main.cadastroProduto();
                        break;
                    case 2://2- Opçao de Compra
                        Main.compras();
                        break;
                    case 3:// - Relatorios
                        Main.relarotioGeral(produtos);
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
    public static void cadastroProduto() {
        int opcao;
        String buscaProduto;
        boolean sair = false;
        while (!sair) {
            String nomeProduto;
            String categoriaProduto;
            double valorProduto = 0;
            int quantidadeProduto = 0;
            int quantiaAdd;
            int idadeRecomentdada = 0;
            String material;
            String corBrinquedo;
            double tamanhoBrinquedo = 0;
            String voltagem = "";
            String modelo;
            double tamanhoEletronico = 0;
            String marca;
            boolean validarInfo = false;
            System.out.print("1- Cadastrar Produto\n" +
                             "2- Atualizar Dados do Produto\n" +
                             "3- Atualizar Quantidade em Estoque\n" +
                             "4- Remover Produto\n"+
                             "0- Sair\nOpção: ");
            try {
                opcao = Integer.parseInt(scan.nextLine());
                switch (opcao) {
                    case 1://1- Cadastrar produto
                        boolean buscaCadastro = false;
                        System.out.print("Nome do Produto: ");
                        nomeProduto = scan.nextLine();
                        if(produtos.size() != 0){
                            for (Produto produto : produtos) {
                                if (produto.getNomeProduto().equals(nomeProduto)) {
                                    System.out.println("Produto ja em Cadastrado!");
                                    buscaCadastro = true;
                                    break;
                                }
                            }
                        }else if(nomeProduto.length() == 0){
                            System.out.println("Por favor Digite um nome valido!");
                            break;
                        }
                        if(produtos.size() == 0 || buscaCadastro != true){
                                System.out.print("Descrição do Produto: ");
                                categoriaProduto = scan.nextLine();
                                System.out.print("Valor Produto: ");
                                validarInfo = false;
                                while (!validarInfo) {
                                    try {
                                        valorProduto = Double.parseDouble(scan.nextLine());
                                        validarInfo = true;
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Valor invalido! Insira um numero valido. ");
                                        System.out.print("Valor Produto: ");
                                    }
                                }
                                validarInfo = false;
                                System.out.print("Quantidade em Estoque: ");
                                while (!validarInfo) {
                                    try {                     
                                        quantidadeProduto = Integer.parseInt(scan.nextLine());
                                        validarInfo = true;
                                        break;
                                    } catch (NumberFormatException e) {
                                        System.out.println("Valor invalido! Insira um numero valido. ");
                                        System.out.print("Quantidade em Estoque: ");
                                    }
                                }
                                Produto novoProduto;
                                int tipoProduto;
                                while(true){
                                    System.out.print("Tipo de Produto:\n" +
                                                    "1- Brinquedo\n" +
                                                    "2- Eletrônico\n" +
                                                    "3- Acessório\n" +
                                                    "0- Cancelar\n" +
                                                    "Opção: ");
                                    tipoProduto = Integer.parseInt(scan.nextLine());
                                    switch (tipoProduto) {
                                        case 1:  // Brinquedo
                                            validarInfo = false;
                                            System.out.print("Idade Recomendada: ");
                                            while (!validarInfo) {
                                                try {    
                                                    idadeRecomentdada = Integer.parseInt(scan.nextLine());
                                                    validarInfo = true;
                                                    break;
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Valor invalido! Insira um numero valido. ");
                                                    System.out.print("Idade Recomendada: ");
                                                }
                                            }
                                            System.out.print("Material: ");
                                            material=scan.nextLine();
                                            System.out.print("Cor: ");
                                            corBrinquedo=scan.nextLine();
                                            System.out.print("Tamanho do Brinquedo (CM): ");
                                            validarInfo = false;
                                            while (!validarInfo) {
                                                try {    
                                                    tamanhoBrinquedo = Double.parseDouble(scan.nextLine());
                                                    validarInfo = true;
                                                    break;
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Valor invalido! Insira um numero valido. ");
                                                    System.out.print("Tamanho do Brinquedo (CM): ");
                                                }
                                            }
                                            novoProduto = new Brinquedo(nomeProduto, categoriaProduto, valorProduto, quantidadeProduto, idadeRecomentdada,material,corBrinquedo,tamanhoBrinquedo);
                                            break;
                                        case 2:  // Eletrônico
                                            System.out.print("Voltagem:\n1- 110 Volts\n2- 220 Volts\n3- Bivolt\nOpcao: ");
                                            validarInfo = false;
                                            while (!validarInfo) {
                                                try {   
                                                    opcao = Integer.parseInt(scan.nextLine());
                                                    switch (opcao) {
                                                        case 1:
                                                            voltagem = "110";
                                                            validarInfo = true;
                                                            break;
                                                        case 2:
                                                            voltagem = "110";
                                                            validarInfo = true;
                                                            break;
                                                        case 3:
                                                            voltagem = "Bivolt";
                                                            validarInfo = true;
                                                            break;
                                                        default:
                                                            System.out.println("Escolha uma opcao valida para voltagem! ");
                                                            scan.nextLine();
                                                    }
                                                } catch (NumberFormatException e) {
                                                        System.out.println("Opcao invalido! Insira um numero valido. ");
                                                        System.out.print("Voltagem:\n1- 110 Volts\n2- 220 Volts\n3- Bivolt\nOpcao: ");
                                                    }
                                                }

                                            System.out.print("Modelo: ");
                                            modelo = scan.nextLine();
                                            System.out.print("Tamanho Eletronico CM: ");
                                            validarInfo = false;
                                            while (!validarInfo) {
                                                try {    
                                                    tamanhoEletronico=Double.parseDouble(scan.nextLine());
                                                    validarInfo = true;
                                                    break;
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Valor invalido! Insira um numero valido. ");
                                                    System.out.print("Tamanho Eletronico CM: ");
                                                }
                                            }
                                            System.out.print("Marca: ");
                                            marca = scan.nextLine();
                                            novoProduto = new Eletronico(nomeProduto, categoriaProduto, valorProduto, quantidadeProduto, voltagem,modelo,tamanhoEletronico,marca);
                                            break;
                                        case 3:  // Acessório
                                            String tipoAcessorio;
                                            System.out.print("Tipo de Acessório: ");
                                            tipoAcessorio = scan.nextLine();
                                            System.out.print("Material: ");
                                            material=scan.nextLine();
                                            System.out.print("Marca: ");
                                            marca=scan.nextLine();
                                            novoProduto = new Acessorio( nomeProduto, categoriaProduto, valorProduto, quantidadeProduto, tipoAcessorio,material,marca);
                                            break;
                                        case 0:
                                            novoProduto = null;
                                            break;
                                        default:
                                            System.out.println("Opção inválida!");
                                            continue;
                                    }
                                    if (novoProduto != null) {
                                        produtos.add(novoProduto);
                                        System.out.println("Produto cadastrado com sucesso!");
                                    }
                                    break;
                                }
                            }   
                        break;
			        case 2://2- Atualização dados do produto
                        System.out.println("Digite o nome do produto: ");
                        buscaProduto = scan.nextLine();
                        for(Produto bProduto : produtos){
                            if (bProduto instanceof Acessorio && bProduto.getNomeProduto().equals(buscaProduto)){
                                System.out.println("Dados a atualizar\n1- Nome do produto\n2- Descrição do produto\n3- Valor do produto\n0- Cancelar Operação\nOpção: ");
                                opcao = Integer.parseInt(scan.nextLine());
                                switch(opcao){
                                    case 1: //1- Nome do produto
                                        System.out.println("Novo nome do produto: ");
                                        nomeProduto = scan.nextLine();
                                        if(nomeProduto.length() == 0){
                                            System.out.println("Digite um nome valido");
                                            break;
                                        }else{
                                            bProduto.setNomeProduto(nomeProduto);
                                            System.out.println("Nome atualizado com sucesso!");
                                        }
                                        break;
                                    case 2://2- Descrição do produto
                                        System.out.println("Descrição do produto: ");
                                        categoriaProduto = scan.nextLine();
                                        bProduto.setCategoriaProduto(categoriaProduto);
                                        System.out.println("Descrição atualizada com sucesso!");
                                        break;
                                    case 3://3- Valor do Produto
                                        validarInfo = false;
                                        System.out.println("Valor do produto: ");
                                        while (!validarInfo) {
                                            try {
                                                valorProduto = Double.parseDouble(scan.nextLine());
                                                bProduto.setValorProduto(valorProduto);
                                                validarInfo = true;
                                                System.out.println("Valor atualizado com sucesso!");
                                                break;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Valor invalido! Insira um numero valido. ");
                                                System.out.print("Valor Produto: ");
                                            }
                                        }
                                        break;
                                    case 0://0- Cancelar Operação
                                        sair = true;
                                        break;
                                    default:
                                        System.out.println("Opcao Invalida!");
                                        break;     
                                }
                            }else if(bProduto instanceof Brinquedo && bProduto.getNomeProduto().equals(buscaProduto)){
                                System.out.println("Dados a atualizar\n1- Nome do produto\n2- Descrição do produto\n3- Valor do produto\n0- Cancelar Operação\nOpção: ");
                                opcao = Integer.parseInt(scan.nextLine());
                                switch(opcao){
                                    case 1: //1- Nome do produto
                                        System.out.println("Novo nome do produto: ");
                                        nomeProduto = scan.nextLine();
                                        if(nomeProduto.length() == 0){
                                            System.out.println("Digite um nome valido");
                                            break;
                                        }else{
                                            bProduto.setNomeProduto(nomeProduto);
                                            System.out.println("Nome atualizado com sucesso!");
                                        }
                                        break;
                                    case 2://2- Descrição do produto
                                        System.out.println("Descrição do produto: ");
                                        categoriaProduto = scan.nextLine();
                                        bProduto.setCategoriaProduto(categoriaProduto);
                                        System.out.println("Descrição atualizada com sucesso!");
                                        break;
                                    case 3:
                                        validarInfo = false;
                                        System.out.println("Valor do produto: ");
                                        while (!validarInfo) {
                                            try {
                                                valorProduto = Double.parseDouble(scan.nextLine());
                                                bProduto.setValorProduto(valorProduto);
                                                validarInfo = true;
                                                System.out.println("Valor atualizado com sucesso!");
                                                break;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Valor invalido! Insira um numero valido. ");
                                                System.out.print("Valor Produto: ");
                                            }
                                        }
                                        break;
                                    case 0://0- Cancelar Operação
                                        sair = true;
                                        break;
                                    default:
                                        System.out.println("Opcao Invalida!");
                                        break;     
                                }
                            }else if(bProduto instanceof Eletronico && bProduto.getNomeProduto().equals(buscaProduto)){
                                System.out.println("Dados a atualizar\n1- Nome do produto\n2- Descrição do produto\n3- Valor do produto\n0- Cancelar Operação\nOpção: ");
                                try{
                                    opcao = Integer.parseInt(scan.nextLine());
                                    switch(opcao){
                                        case 1: //1- Nome do produto
                                            System.out.println("Novo nome do produto: ");
                                            nomeProduto = scan.nextLine();
                                            if(nomeProduto.length() == 0){
                                                System.out.println("Digite um nome valido");
                                                break;
                                            }else{
                                                bProduto.setNomeProduto(nomeProduto);
                                                System.out.println("Nome atualizado com sucesso!");
                                            }
                                            break;
                                        case 2://2- Descrição do produto
                                            System.out.println("Descrição do produto: ");
                                            categoriaProduto = scan.nextLine();
                                            bProduto.setCategoriaProduto(categoriaProduto);
                                            System.out.println("Descrição atualizada com sucesso!");
                                            break;
                                        case 3:
                                            validarInfo = false;
                                            System.out.println("Valor do produto: ");
                                            while (!validarInfo) {
                                                try {
                                                    valorProduto = Double.parseDouble(scan.nextLine());
                                                    bProduto.setValorProduto(valorProduto);
                                                    validarInfo = true;
                                                    System.out.println("Valor atualizado com sucesso!");
                                                    break;
                                                } catch (NumberFormatException e) {
                                                    System.out.println("Valor invalido! Insira um numero valido. ");
                                                    System.out.print("Valor Produto: ");
                                                }
                                            }
                                            break;
                                        case 0://0- Cancelar Operação
                                            sair = true;
                                            break;
                                        default:
                                            System.out.println("Opcao Invalida!");
                                            break;     
                                    }
                                }catch(NumberFormatException e){
                                    System.err.println("Opcao Invalida!");
                                }   
                            }
                        }
                        break;
                    case 3://3- Atualizar quantia em estoque
                        validarInfo = false;
                        System.out.println("Digite o nome do produto: ");
                        buscaProduto = scan.nextLine();
                        for(Produto bProduto : produtos){
                            if (bProduto instanceof Acessorio && bProduto.getNomeProduto().equals(buscaProduto)){
                                System.out.println("\nProduto: "+bProduto.getNomeProduto()+"\nQuantidade: "+bProduto.getQuantidadeProduto());
                                System.out.println("1- Adicionar quantia\n2- Modificar quantia\n0- Cancelar Operação\nOpção: ");
                                opcao = Integer.parseInt(scan.nextLine());
                                switch(opcao){
                                    case 1: //1- Adicionar quantia
                                        validarInfo = false;
                                        System.out.println("Quantia a acrescentar: ");
                                        while (!validarInfo) {
                                            try {
                                                quantiaAdd = Integer.parseInt(scan.nextLine());
                                                bProduto.atualizarQuantidadeEstoque(quantiaAdd);
                                                validarInfo = true;
                                                System.out.println("Quantia Acrescentada com sucesso! ");
                                                break;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Valor invalido! Insira um numero valido. ");
                                                System.out.println("Quantia a acrescentar: ");
                                            }
                                        }
                                        break;
                                    case 2://2- Modificar quantia
                                        validarInfo = false;
                                        System.out.println("Nova Quantidade: ");
                                        while (!validarInfo) {
                                            try {
                                                quantiaAdd = Integer.parseInt(scan.nextLine());
                                                bProduto.setQuantidadeProduto(quantiaAdd); 
                                                validarInfo = true;
                                                System.out.println("Quantia modificada com sucesso!");
                                                break;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Valor invalido! Insira um numero valido. ");
                                                System.out.println("Nova Quantidade: ");
                                            }
                                        }
                                        break;
                                    case 0://0- Cancelar Operação
                                        sair = true;
                                        break;
                                    default:
                                        System.out.println("Opcao Invalida!");
                                        break;     
                                }
                            }else if(bProduto instanceof Brinquedo && bProduto.getNomeProduto().equals(buscaProduto)){
                                System.out.println("\nProduto: "+bProduto.getNomeProduto()+"\nQuantidade: "+bProduto.getQuantidadeProduto());
                                System.out.println("1- Adicionar quantia\n2- Modificar quantia\n0- Cancelar Operação\nOpção: ");
                                opcao = Integer.parseInt(scan.nextLine());
                                switch(opcao){
                                    case 1: //1- Adicionar quantia
                                        validarInfo = false;
                                        System.out.println("Quantia a acrescentar: ");
                                        while (!validarInfo) {
                                            try {
                                                quantiaAdd = Integer.parseInt(scan.nextLine());
                                                bProduto.atualizarQuantidadeEstoque(quantiaAdd);
                                                validarInfo = true;
                                                System.out.println("Quantia Acrescentada com sucesso! ");
                                                break;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Valor invalido! Insira um numero valido. ");
                                                System.out.println("Quantia a acrescentar: ");
                                            }
                                        }
                                        break;
                                    case 2://2- Modificar quantia
                                        validarInfo = false;
                                        System.out.println("Nova Quantidade: ");
                                        while (!validarInfo) {
                                            try {
                                                quantiaAdd = Integer.parseInt(scan.nextLine());
                                                bProduto.setQuantidadeProduto(quantiaAdd); 
                                                System.out.println("Quantia modificada com sucesso!");
                                                validarInfo = true;
                                                break;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Valor invalido! Insira um numero valido. ");
                                                System.out.println("Nova Quantidade: ");
                                            }
                                        }
                                        break;
                                    case 0://0- Cancelar Operação
                                        sair = true;
                                        break;
                                    default:
                                        System.out.println("Opcao Invalida!");
                                        break;     
                                }
                            }else if(bProduto instanceof Eletronico && bProduto.getNomeProduto().equals(buscaProduto)){
                                System.out.println("\nProduto: "+bProduto.getNomeProduto()+"\nQuantidade: "+bProduto.getQuantidadeProduto());
                                System.out.println("1- Adicionar quantia\n2- Modificar quantia\n0- Cancelar Operação\nOpção: ");
                                opcao = Integer.parseInt(scan.nextLine());
                                switch(opcao){
                                    case 1: //1- Adicionar quantia
                                        validarInfo = false;
                                        System.out.println("Quantia a acrescentar: ");
                                        while (!validarInfo) {
                                            try {
                                                quantiaAdd = Integer.parseInt(scan.nextLine());
                                                bProduto.atualizarQuantidadeEstoque(quantiaAdd);
                                                validarInfo = true;
                                                System.out.println("Quantia Acrescentada com sucesso! ");
                                                break;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Valor invalido! Insira um numero valido. ");
                                                System.out.println("Quantia a acrescentar: ");
                                            }
                                        }
                                        break;
                                    case 2://2- Modificar quantia
                                        validarInfo = false;
                                        System.out.println("Nova Quantidade: ");
                                        while (!validarInfo) {
                                            try {
                                                quantiaAdd = Integer.parseInt(scan.nextLine());
                                                bProduto.setQuantidadeProduto(quantiaAdd); 
                                                System.out.println("Quantia modificada com sucesso!");
                                                validarInfo = true;
                                                break;
                                            } catch (NumberFormatException e) {
                                                System.out.println("Valor invalido! Insira um numero valido. ");
                                                System.out.println("Nova Quantidade: ");
                                            }
                                        }
                                        break;
                                    case 0://0- Cancelar Operação
                                        sair = true;
                                        break;
                                    default:
                                        System.out.println("Opcao Invalida!");
                                        break;     
                                }
                            }else{System.out.println("Produto não localizado!");}
                        }
                        break;
                    case 4://4- Remover produto --- arrumar
                        System.out.println("Produto a ser removido - Nome: ");
                        String removeProduto = scan.nextLine();
                        Iterator<Produto> iter = produtos.iterator();
                        if(produtos.size() != 0){
                            while (iter.hasNext()) {
                                Produto bProduto = iter.next();
                                if (bProduto instanceof Eletronico && bProduto.getNomeProduto().equals(removeProduto)) {
                                    iter.remove(); // Remove o item usando o iterador
                                    sair = true;
                                    break;
                                } else if (bProduto instanceof Brinquedo && bProduto.getNomeProduto().equals(removeProduto)) {
                                    iter.remove(); // Remove o item usando o iterador
                                    sair = true;
                                    break;
                                } else if (bProduto instanceof Acessorio && bProduto.getNomeProduto().equals(removeProduto)) {
                                    iter.remove(); // Remove o item usando o iterador
                                    sair = true;
                                    break;
                                }
                                break;
                            }
                        }else{
                            System.out.println("Nenhum produto cadastrado!");
                        }
                        if (!sair) {
                            System.out.println("Produto não encontrado.");
                        }
                        break;
                    case 0:
                        sair = true;
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            }catch(NumberFormatException e) {
                System.err.println("Por favor, insira um número válido.");
            }catch(RuntimeException e ){
                System.err.println("Quantidade Invalida! " + e.getMessage());
            }
        }
    }
    public static void compras(){
    boolean validarInfo = false;
    int opcao;
    boolean sair = false;
    Carrinho carrinho = new Carrinho(); // Criar um carrinho
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
                        Main.formaPagamento(totalCompra);
                        totalCompra = carrinho.calcularTotal();
                        totalVendasCaixa += totalCompra;
                        sair = true;
                    } else {
                        System.out.println("O carrinho está vazio. Adicione produtos antes de finalizar a compra.");
                    }
                    break;

                case 0://0- Sair
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } catch (NumberFormatException e) {
            System.err.println("Por favor, insira um número válido.");
        } 
    }
}
    public static void formaPagamento(double valorCompra){
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
                        totalVendasCaixaPag += pagamentoDinheiro.getValorComDesconto();
                        System.out.println(pagamentoDinheiro.toString());
                        sair = true;
                        break;
                    case 2://Debito
                        // Processando o pagamento com cartão de débito
                        I_Pagamento pagamentoDebito = new PagamentoDebito(valorCompra);
                        pagamentoDebito.processoPagamento(valorCompra);
                        totalVendasCaixaPag += pagamentoDebito.getValorComDesconto();
                        System.out.println(pagamentoDebito.toString());
                        sair = true;
                        break;
                    case 3://Credito
                        try {
                            System.out.println("Digite o numero de parcelas enntre 1 ate 6 vezes: \nParcelas:");
                            int parcelas = Integer.parseInt(scan.nextLine());
                            I_Pagamento pagamentoCredito= new PagamentoCredito(valorCompra,parcelas);
                            if(parcelas > 0 && parcelas < 6){
                                // Processando o pagamento com cartão de crédito
                                pagamentoCredito.processoPagamento(valorCompra);
                                totalVendasCaixaPag += pagamentoCredito.getValorComDesconto();
                                System.out.println(pagamentoCredito.toString());
                                sair = true;
                                break;
                            }  
                        }catch (NumberFormatException e) {
                            System.err.println("Por favor, insira um número válido.");
                        }
                        break;
                    case 4://Pix 
                        // Processando o pagamento Pix
                        I_Pagamento pagamentoPix= new PagamentoPix(valorCompra);
                        pagamentoPix.processoPagamento(valorCompra);
                        totalVendasCaixaPag += pagamentoPix.getValorComDesconto();
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
    public static void relarotioGeral(ArrayList<Produto> produtos) {
        int opcao;
        boolean sair = false;
        try {
            while (!sair) {
                System.out.println("1- Relatorio Caixa\n2- Relatorio Estoque\n0- Sair\nOpção: ");
                opcao = Integer.parseInt(scan.nextLine());
                switch (opcao) {
                    case 1: // Relatório Caixa
                        Main.relatorioCaixa();
                        break;
                    case 2: // Relatório Estoque
                        I_Relatorio relatorioEstoque = new RelatorioEstoque(produtos);
                        relatorioEstoque.relatorioGeral();
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
    public static void relatorioCaixa(){
        System.out.printf("Relatorio de Caixa\nTotal de Venda Com Desconto: %.2f \nTotal de Venda Bruto sem descontos aplicados: %.2f \nValor total desconto aplicado: %.2f\n",totalVendasCaixaPag,totalVendasCaixa,(totalVendasCaixa-totalVendasCaixaPag));
    }
}
