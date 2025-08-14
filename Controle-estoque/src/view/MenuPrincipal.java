// package view;

//import model.*;
//import service.GerenciadorDeDados;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {

    private static int idProduto = 1;
    private static int idFornecedor = 1;
    private static int idCategoria = 1;
    private static int idMovimento = 1;

    public static void iniciar() {
        Scanner sc = new Scanner(System.in);
        GerenciadorDeDados gerenciador = new GerenciadorDeDados();

        while (true) {
            System.out.println("\n=== SISTEMA DE ESTOQUE ===");
            System.out.println("1 - Cadastrar Categoria");
            System.out.println("2 - Cadastrar Fornecedor");
            System.out.println("3 - Cadastrar Produto");
            System.out.println("4 - Editar Categoria");
            System.out.println("5 - Remover Categoria");
            System.out.println("6 - Editar Fornecedor");
            System.out.println("7 - Remover Fornecedor");
            System.out.println("8 - Editar Produto");
            System.out.println("9 - Remover Produto");
            System.out.println("10 - Entrada de Estoque");
            System.out.println("11 - Saída de Estoque");
            System.out.println("12 - Listar Produtos");
            System.out.println("13 - Listar Estoque Baixo");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int op = Integer.parseInt(sc.nextLine());

            try {
                switch (op) {
                    case 0:
                        System.out.println("Saindo do sistema. Até mais!");
                        return;

                    case 1:
                        System.out.print("Nome Categoria: "); String nomeC = sc.nextLine();
                        gerenciador.cadastrarCategoria(new Categoria(idCategoria++, nomeC));
                        System.out.println("Categoria cadastrada.");
                        break;
                    
                    case 2:
                        System.out.print("Nome Fornecedor: "); String nomeF = sc.nextLine();
                        Fornecedor novoF = new Fornecedor(idFornecedor++, nomeF);
                        gerenciador.cadastrarFornecedor(novoF);
                        System.out.println("Fornecedor cadastrado.");
                        break;

                    case 3:
                        if (gerenciador.listarCategorias().isEmpty() || gerenciador.listarFornecedores().isEmpty()) {
                            System.out.println("Cadastre pelo menos 1 categoria e 1 fornecedor antes.");
                            break;
                        }
                        System.out.print("Nome Produto: ");
                        String nomeP = sc.nextLine();
                        System.out.print("Estoque mínimo: ");
                        int min = Integer.parseInt(sc.nextLine());

                        System.out.println("Categorias disponíveis:");
                        for (Categoria c : gerenciador.listarCategorias())
                            System.out.println(c.getId() + " - " + c.getNome());
                        System.out.print("ID categoria: ");
                        int idCat = Integer.parseInt(sc.nextLine());
                        Categoria cat = gerenciador.consultarCategoria(idCat);

                        if (cat == null) {
                            System.out.println("Categoria não encontrada.");
                            break;
                        }

                        // Cria o objeto Produto com o construtor do nosso modelo
                        Produto p = new Produto(idProduto++, nomeP, min, cat);
                        gerenciador.cadastrarProduto(p);
                        
                        // Lógica para adicionar o Fornecimento inicial
                        System.out.println("Adicionar fornecimento inicial:");
                        System.out.println("Fornecedores disponíveis:");
                        for (Fornecedor f : gerenciador.listarFornecedores())
                            System.out.println(f.getId() + " - " + f.getNome());
                        System.out.print("ID fornecedor: ");
                        int idFor = Integer.parseInt(sc.nextLine());
                        Fornecedor fornec = gerenciador.consultarFornecedor(idFor);

                        if (fornec != null) {
                            System.out.print("Preço de custo inicial: ");
                            double pc = Double.parseDouble(sc.nextLine());
                            System.out.print("Preço de venda inicial: ");
                            double pv = Double.parseDouble(sc.nextLine());

                            Fornecimento novoForn = new Fornecimento(fornec, p, pc, pv);
                            gerenciador.adicionarOuAtualizarFornecimento(p, novoForn);
                        } else {
                            System.out.println("Fornecedor não encontrado. Produto cadastrado sem fornecimento inicial.");
                        }
                        
                        System.out.println("Produto cadastrado.");
                        break;       

                    case 4:
                        System.out.print("ID da Categoria a editar: "); int idCatEd = Integer.parseInt(sc.nextLine());
                        Categoria catEd = gerenciador.consultarCategoria(idCatEd);
                        if (catEd == null) { System.out.println("Categoria não encontrada."); break; }
                        System.out.print("Novo nome: "); String novoNomeCat = sc.nextLine();
                        Categoria catAtualizada = new Categoria(idCatEd, novoNomeCat);
                        gerenciador.atualizarCategoria(idCatEd, catAtualizada);
                        System.out.println("Categoria atualizada.");
                        break;

                    case 5:
                        System.out.print("ID da Categoria a remover: "); int idCatRem = Integer.parseInt(sc.nextLine());
                        gerenciador.removerCategoria(idCatRem);
                        System.out.println("Categoria removida.");
                        break;

                    case 6:
                        System.out.print("ID do Fornecedor a editar: "); int idForEd = Integer.parseInt(sc.nextLine());
                        Fornecedor forEd = gerenciador.consultarFornecedor(idForEd);
                        if (forEd == null) { System.out.println("Fornecedor não encontrado."); break; }
                        System.out.print("Novo nome: "); String novoNomeFor = sc.nextLine();
                        Fornecedor forAtualizado = new Fornecedor(idForEd, novoNomeFor);
                        gerenciador.atualizarFornecedor(idForEd, forAtualizado);
                        System.out.println("Fornecedor atualizado.");
                        break;

                    case 7:
                        System.out.print("ID do Fornecedor a remover: "); int idForRem = Integer.parseInt(sc.nextLine());
                        gerenciador.removerFornecedor(idForRem);
                        System.out.println("Fornecedor removido.");
                        break;

                     case 8: 
                        System.out.print("ID do Produto a editar: ");
                        int idProdEd = Integer.parseInt(sc.nextLine());
                        Produto prodEd = gerenciador.consultarProduto(idProdEd);
                        if (prodEd == null) {
                            System.out.println("Produto não encontrado.");
                            break;
                        }

                        System.out.println("O que você deseja editar?");
                        System.out.println("1- Nome");
                        System.out.println("2- Categoria");
                        System.out.println("3- Estoque Mínimo");
                        System.out.println("4- Adicionar/Atualizar Fornecimento");
                        System.out.print("Opção: ");
                        int subOp = Integer.parseInt(sc.nextLine());

                        switch (subOp) {
                            case 1:
                                System.out.print("Novo nome: ");
                                String novoNomeProd = sc.nextLine();
                                prodEd.setNome(novoNomeProd);
                                gerenciador.atualizarProduto(idProdEd, prodEd);
                                System.out.println("Nome do produto atualizado.");
                                break;
                            case 2:
                                System.out.println("Categorias disponíveis:");
                                for (Categoria c : gerenciador.listarCategorias()) {
                                    System.out.println(c.getId() + " - " + c.getNome());
                                }
                                System.out.print("ID da nova categoria: ");
                                int idNovaCat = Integer.parseInt(sc.nextLine());
                                Categoria novaCat = gerenciador.consultarCategoria(idNovaCat);
                                if (novaCat != null) {
                                    prodEd.setCategoria(novaCat);
                                    gerenciador.atualizarProduto(idProdEd, prodEd);
                                    System.out.println("Categoria do produto atualizada.");
                                } else {
                                    System.out.println("Categoria não encontrada.");
                                }
                                break;
                            case 3:
                                System.out.print("Novo estoque mínimo: ");
                                int novoEstMin = Integer.parseInt(sc.nextLine());
                                prodEd.setEstoqueMinimo(novoEstMin);
                                gerenciador.atualizarProduto(idProdEd, prodEd);
                                System.out.println("Estoque mínimo atualizado.");
                                break;
                            case 4:
                                System.out.println("Fornecedores disponíveis:");
                                for (Fornecedor f : gerenciador.listarFornecedores()) {
                                    System.out.println(f.getId() + " - " + f.getNome());
                                }
                                System.out.print("ID do fornecedor: ");
                                int idForn = Integer.parseInt(sc.nextLine());
                                Fornecedor forn = gerenciador.consultarFornecedor(idForn);
                                if (forn != null) {
                                    System.out.print("Novo preço de custo: ");
                                    double pc = Double.parseDouble(sc.nextLine());
                                    System.out.print("Novo preço de venda: ");
                                    double pv = Double.parseDouble(sc.nextLine());
                                    // A lógica completa de atualização de Fornecimento está no GerenciadorDeDados
                                    Fornecimento novoForn = new Fornecimento(forn, prodEd, pc, pv);
                                     gerenciador.adicionarOuAtualizarFornecimento(prodEd, novoForn);
                                    
                                    System.out.println("Fornecimento atualizado.");
                                } else {
                                    System.out.println("Fornecedor não encontrado.");
                                }
                                break;
                            default:
                                System.out.println("Opção inválida.");
                        }
                        break; 
                    
                    case 9: 
                        System.out.print("ID do Produto a remover: ");
                        int idProdRem = Integer.parseInt(sc.nextLine());
                        Produto prodRem = gerenciador.consultarProduto(idProdRem);
                        if (prodRem == null) {
                            System.out.println("Produto não encontrado.");
                        } else {
                            gerenciador.removerProduto(idProdRem);
                            System.out.println("Produto removido.");
                        }
                        break;


                    case 10:
                        System.out.print("ID do Produto para entrada: ");
                        int idProdEnt = Integer.parseInt(sc.nextLine());
                        Produto prodEnt = gerenciador.consultarProduto(idProdEnt);

                        if (prodEnt == null) {
                            System.out.println("Produto não encontrado.");
                            break;
                        }

                        System.out.print("Quantidade a adicionar: ");
                        int qtdEnt = Integer.parseInt(sc.nextLine());

                        System.out.print("ID do Fornecedor: ");
                        int idFornEnt = Integer.parseInt(sc.nextLine());
                        Fornecedor fornEnt = gerenciador.consultarFornecedor(idFornEnt);

                        if (fornEnt == null) {
                            System.out.println("Fornecedor não encontrado.");
                            break;
                        }

                        // Cria o objeto de entrada de estoque
                        EntradaEstoque novaEntrada = new EntradaEstoque(idMovimento++, new Date(), prodEnt, qtdEnt, fornEnt);

                        // Registra a entrada no gerenciador
                        gerenciador.registrarEntrada(novaEntrada);
                        System.out.println("Entrada de estoque registrada com sucesso.");
                        break;

                    case 11: 
                        System.out.print("ID do Produto para saída: ");
                        int idProdSai = Integer.parseInt(sc.nextLine());
                        Produto prodSai = gerenciador.consultarProduto(idProdSai);

                        if (prodSai == null) {
                            System.out.println("Produto não encontrado.");
                            break;
                        }

                        System.out.print("Quantidade a ser retirada: ");
                        int qtdSai = Integer.parseInt(sc.nextLine());

                        System.out.print("Motivo da saída: ");
                        String motivo = sc.nextLine();

                        // Cria o objeto de saída de estoque
                        SaidaEstoque novaSaida = new SaidaEstoque(idMovimento++, new Date(), prodSai, qtdSai, motivo);

                        // Registra a saída no gerenciador, que irá atualizar o estoque
                        gerenciador.registrarSaida(novaSaida);
                        System.out.println("Saída de estoque registrada com sucesso.");
                        break;

                    case 12: 
                        System.out.println("--- LISTA DE PRODUTOS ---");
                        List<Produto> listaDeProdutos = gerenciador.listarProdutos();
                        if (listaDeProdutos.isEmpty()) {
                            System.out.println("Nenhum produto cadastrado no sistema.");
                        } else {
                            for (Produto produto : listaDeProdutos) {
                                System.out.println("ID: " + produto.getId() + ", Nome: " + produto.getNome() +
                                                ", Estoque Atual: " + produto.getEstoqueAtual() +
                                                ", Estoque Mínimo: " + produto.getEstoqueMinimo() +
                                                ", Categoria: " + produto.getCategoria().getNome());
                            }
                        }
                        break;

                    case 13:
                        System.out.println("--- PRODUTOS COM ESTOQUE BAIXO ---");
                        List<Produto> produtosBaixoEstoque = gerenciador.gerarAlertaDeEstoqueMinimo();
                        if (produtosBaixoEstoque.isEmpty()) {
                            System.out.println("Nenhum produto com estoque abaixo do mínimo.");
                        } else {
                            for (Produto produto : produtosBaixoEstoque) {
                                System.out.println("ALERTA: O produto '" + produto.getNome() + "' está com estoque baixo!");
                                System.out.println("Estoque Atual: " + produto.getEstoqueAtual() +
                                                ", Estoque Mínimo: " + produto.getEstoqueMinimo());
                            }
                        }
                        break;

                    default:
                        System.out.println("Opção inválida."); 
                }
            } catch (Exception e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }
}