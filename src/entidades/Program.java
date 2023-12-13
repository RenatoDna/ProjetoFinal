package entidades;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import produto.*;

public class Program {

    // Cadastro de produtos 
    public static void cadastroProduto(Scanner scan,ArrayList<Produto> produtos) {
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
            Produto novoProduto;
            int tipoProduto;
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
                        if(produtos.size() != 0){ // caso o nome do produto seja vazio não cadastra
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
                        if (produtos.size() != 0){
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
                        }
                        else{
                            System.out.println("Nenhum produto cadastrado!");
                        }
                        break;
                    case 3://3- Atualizar quantia em estoque
                        validarInfo = false;
                        if(produtos.size() != 0){
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
                        }else{
                            System.out.println("Nenhum produto Cadastrado!");
                        }
                        break;
                    case 4://4- Remover produto do estoque 
                        System.out.println("Produto a ser removido - Nome: ");
                        String removeProduto = scan.nextLine();
                        Iterator<Produto> iter = produtos.iterator();
                        if(produtos.size() == 0){
                            System.out.println("Nenhum produto cadastrado!");
                        }else{
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
}
