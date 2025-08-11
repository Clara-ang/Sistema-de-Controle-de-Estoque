package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.*;
import service.EstoqueService;

public class MenuPrincipal {
    public static void iniciar() {
        Scanner sc = new Scanner(System.in);
        EstoqueService estoque = new EstoqueService();
        List<Categoria> categorias = new ArrayList<>();
        List<Fornecedor> fornecedores = new ArrayList<>();

        while (true) {
            System.out.println("\n=== MENU ESTOQUE ===");
            System.out.println("1 - Cadastrar Categoria");
            System.out.println("2 - Cadastrar Fornecedor");
            System.out.println("3 - Cadastrar Produto");
            System.out.println("4 - Entrada de Produto");
            System.out.println("5 - Saída de Produto");
            System.out.println("6 - Listar Produtos");
            System.out.println("7 - Estoque Baixo");
            System.out.println("8 - Editar Categoria/Fornecedor de Produto");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int op = sc.nextInt();

            try {
                if (op == 0) break;
                switch (op) {
                    case 1:
                        System.out.print("ID Categoria: ");
                        int idC = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nome Categoria: ");
                        String nomeC = sc.nextLine();
                        categorias.add(new Categoria(idC, nomeC));
                        System.out.println("Categoria cadastrada com sucesso!");
                        break;

                    case 2:
                        System.out.print("ID Fornecedor: ");
                        int idF = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nome Fornecedor: ");
                        String nomeF = sc.nextLine();
                        System.out.print("Email Fornecedor: ");
                        String emailF = sc.nextLine();
                        fornecedores.add(new Fornecedor(idF, nomeF, emailF));
                        System.out.println("Fornecedor cadastrado com sucesso!");
                        break;

                    case 3:
                        if (categorias.isEmpty() || fornecedores.isEmpty()) {
                            System.out.println("Cadastre pelo menos 1 categoria e 1 fornecedor antes de cadastrar um produto!");
                            break;
                        }
                        System.out.print("ID Produto: ");
                        int idP = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Nome Produto: ");
                        String nomeP = sc.nextLine();
                        System.out.print("Quantidade inicial: ");
                        int qtd = sc.nextInt();
                        System.out.print("Estoque mínimo: ");
                        int min = sc.nextInt();

                        System.out.println("Escolha a Categoria:");
                        for (Categoria c : categorias) {
                            System.out.println(c.getId() + " - " + c.getNome());
                        }
                        int idCatEscolhida = sc.nextInt();
                        Categoria catEscolhida = categorias.stream()
                                .filter(c -> c.getId() == idCatEscolhida)
                                .findFirst().orElse(null);

                        System.out.println("Escolha o Fornecedor:");
                        for (Fornecedor f : fornecedores) {
                            System.out.println(f.getId() + " - " + f.getNome());
                        }
                        int idForEscolhido = sc.nextInt();
                        Fornecedor forEscolhido = fornecedores.stream()
                                .filter(f -> f.getId() == idForEscolhido)
                                .findFirst().orElse(null);

                        Produto novoProduto = new Produto(idP, nomeP, catEscolhida, forEscolhido, qtd, min);
                        estoque.cadastrarProduto(novoProduto);
                        System.out.println("Produto cadastrado com sucesso!");
                        break;

                    case 4:
                        System.out.print("ID Produto: ");
                        int idEntrada = sc.nextInt();
                        System.out.print("Qtd: ");
                        int qtdE = sc.nextInt();
                        estoque.entradaProduto(idEntrada, qtdE);
                        System.out.println("Entrada registrada.");
                        break;

                    case 5:
                        System.out.print("ID Produto: ");
                        int idSaida = sc.nextInt();
                        System.out.print("Qtd: ");
                        int qtdS = sc.nextInt();
                        estoque.saidaProduto(idSaida, qtdS);
                        System.out.println("Saída registrada.");
                        break;

                    case 6:
                        estoque.listarProdutos().forEach(System.out::println);
                        break;

                    case 7:
                        List<Produto> alerta = estoque.listarEstoqueBaixo();
                        if (alerta.isEmpty()) {
                            System.out.println("Nenhum produto com estoque baixo.");
                        } else {
                            alerta.forEach(System.out::println);
                        }
                        break;

                    case 8:
                        System.out.print("ID Produto para editar: ");
                        int idEdit = sc.nextInt();
                        Produto prodEdit = estoque.buscarProduto(idEdit);
                        if (prodEdit == null) {
                            System.out.println("Produto não encontrado!");
                            break;
                        }

                        System.out.println("Editar Categoria:");
                        for (Categoria c : categorias) {
                            System.out.println(c.getId() + " - " + c.getNome());
                        }
                        int idNovaCat = sc.nextInt();
                        Categoria novaCat = categorias.stream()
                                .filter(c -> c.getId() == idNovaCat)
                                .findFirst().orElse(null);
                        prodEdit.setCategoria(novaCat);

                        System.out.println("Editar Fornecedor:");
                        for (Fornecedor f : fornecedores) {
                            System.out.println(f.getId() + " - " + f.getNome());
                        }
                        int idNovoFor = sc.nextInt();
                        Fornecedor novoFor = fornecedores.stream()
                                .filter(f -> f.getId() == idNovoFor)
                                .findFirst().orElse(null);
                        prodEdit.setFornecedor(novoFor);

                        System.out.println("Produto atualizado!");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
}
