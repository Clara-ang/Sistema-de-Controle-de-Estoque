package view;

import java.util.List;
import java.util.Scanner;

import model.Categoria;
import model.Fornecedor;
import model.Fornecimento;
import model.Produto;
import service.EstoqueService;

public class MenuPrincipal {
    public static void iniciar() {
        Scanner sc = new Scanner(System.in);
        EstoqueService estoque = new EstoqueService();

        while (true) {
            System.out.println("\n=== SISTEMA DE ESTOQUE ===");
            System.out.println("1 - Cadastrar Categoria");
            System.out.println("2 - Cadastrar Fornecedor");
            System.out.println("3 - Cadastrar Produto");
            System.out.println("4 - Entrada de Estoque (compras)");
            System.out.println("5 - Saída de Estoque (venda/uso)");
            System.out.println("6 - Listar Produtos");
            System.out.println("7 - Listar Estoque Baixo");
            System.out.println("8 - Editar Produto (categoria/fornecedor/preço)");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            int op = Integer.parseInt(sc.nextLine());

            try {
                switch (op) {
                    case 0: return;

                    case 1:
                        System.out.print("ID Categoria: "); int idC = Integer.parseInt(sc.nextLine());
                        System.out.print("Nome Categoria: "); String nomeC = sc.nextLine();
                        System.out.print("Descrição (opcional): "); String desc = sc.nextLine();
                        estoque.adicionarCategoria(new Categoria(idC, nomeC, desc));
                        System.out.println("Categoria cadastrada.");
                        break;

                    case 2:
                        System.out.print("ID Fornecedor: "); int idF = Integer.parseInt(sc.nextLine());
                        System.out.print("Nome Fornecedor: "); String nomeF = sc.nextLine();
                        System.out.print("CNPJ: "); String cnpjF = sc.nextLine();
                        System.out.print("Contato (email/telefone): "); String cont = sc.nextLine();
                        estoque.adicionarFornecedor(new Fornecedor(idF, nomeF, cnpjF, cont));
                        System.out.println("Fornecedor cadastrado.");
                        break;

                    case 3:
                        if (estoque.listarCategorias().isEmpty() || estoque.listarFornecedores().isEmpty()) {
                            System.out.println("Cadastre pelo menos 1 categoria e 1 fornecedor antes.");
                            break;
                        }
                        System.out.print("ID Produto: "); int idP = Integer.parseInt(sc.nextLine());
                        System.out.print("Nome Produto: "); String nomeP = sc.nextLine();
                        System.out.print("Preço Compra: "); double pc = Double.parseDouble(sc.nextLine());
                        System.out.print("Preço Venda: "); double pv = Double.parseDouble(sc.nextLine());
                        System.out.print("Estoque inicial: "); int est = Integer.parseInt(sc.nextLine());
                        System.out.print("Estoque mínimo: "); int min = Integer.parseInt(sc.nextLine());

                        System.out.println("Categorias:");
                        for (Categoria c : estoque.listarCategorias()) System.out.println(c.getId() + " - " + c.getNome());
                        System.out.print("ID categoria: "); int idCat = Integer.parseInt(sc.nextLine());
                        Categoria cat = estoque.buscarCategoria(idCat);

                        Produto p = new Produto(idP, nomeP, pc, pv, est, min, cat);
                        // associar um fornecedor padrão (opcional)
                        System.out.println("Fornecedores:");
                        for (Fornecedor f : estoque.listarFornecedores()) System.out.println(f.getId() + " - " + f.getNome());
                        System.out.print("ID fornecedor padrão (ou 0 p/nenhum): ");
                        int idFor = Integer.parseInt(sc.nextLine());
                        if (idFor != 0) {
                            Fornecedor fornec = estoque.buscarFornecedor(idFor);
                            if (fornec != null) p.adicionarFornecedor(new Fornecimento(p, fornec));
                        }

                        estoque.adicionarProduto(p);
                        System.out.println("Produto cadastrado.");
                        break;

                    case 4:
                        System.out.print("ID Produto (entrada): "); int idEnt = Integer.parseInt(sc.nextLine());
                        System.out.print("Quantidade: "); int qtdEnt = Integer.parseInt(sc.nextLine());
                        System.out.print("ID Fornecedor: "); int idForE = Integer.parseInt(sc.nextLine());
                        Fornecedor fEnt = estoque.buscarFornecedor(idForE);
                        estoque.aumentarEstoque(idEnt, qtdEnt, fEnt);
                        System.out.println("Entrada registrada.");
                        break;

                    case 5:
                        System.out.print("ID Produto (saída): "); int idSai = Integer.parseInt(sc.nextLine());
                        System.out.print("Quantidade: "); int qtdSai = Integer.parseInt(sc.nextLine());
                        System.out.print("ID Fornecedor (opcional, 0 se não): "); int idForS = Integer.parseInt(sc.nextLine());
                        Fornecedor fSai = idForS == 0 ? null : estoque.buscarFornecedor(idForS);
                        estoque.diminuirEstoque(idSai, qtdSai, fSai);
                        System.out.println("Saída registrada.");
                        break;

                    case 6:
                        List<Produto> lista = estoque.listarProdutos();
                        if (lista.isEmpty()) System.out.println("Nenhum produto cadastrado.");
                        else for (Produto prod : lista) System.out.println(prod);
                        break;

                    case 7:
                        List<Produto> baixos = estoque.listarEstoqueBaixo();
                        if (baixos.isEmpty()) System.out.println("Nenhum produto com estoque baixo.");
                        else for (Produto bp : baixos) bp.mostrarDetalhes();
                        break;

                    case 8:
                        System.out.print("ID Produto a editar: "); int idEd = Integer.parseInt(sc.nextLine());
                        Produto prodEd = estoque.buscarProduto(idEd);
                        if (prodEd == null) { System.out.println("Produto não encontrado."); break; }

                        System.out.println("1- mudar categoria  2- adicionar fornecedor  3- atualizar preço");
                        int sub = Integer.parseInt(sc.nextLine());
                        if (sub == 1) {
                            System.out.println("Categorias:");
                            for (Categoria c2 : estoque.listarCategorias()) System.out.println(c2.getId() + " - " + c2.getNome());
                            System.out.print("ID nova categoria: "); int idNc = Integer.parseInt(sc.nextLine());
                            Categoria nc = estoque.buscarCategoria(idNc);
                            prodEd.setCategoria(nc);
                            System.out.println("Categoria atualizada.");
                        } else if (sub == 2) {
                            System.out.println("Fornecedores:");
                            for (Fornecedor ff : estoque.listarFornecedores()) System.out.println(ff.getId() + " - " + ff.getNome());
                            System.out.print("ID fornecedor a adicionar: "); int idAf = Integer.parseInt(sc.nextLine());
                            Fornecedor af = estoque.buscarFornecedor(idAf);
                            if (af != null) prodEd.adicionarFornecedor(new Fornecimento(prodEd, af));
                            System.out.println("Fornecedor associado.");
                        } else if (sub == 3) {
                            System.out.print("Novo preço de venda: "); double novo = Double.parseDouble(sc.nextLine());
                            prodEd.atualizarPreco(novo);
                            System.out.println("Preço atualizado.");
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;


                    default:
                        System.out.println("Opção inválida.");
                }
            }catch (Exception e) {
                System.out.println("ERRO: " + e.getMessage());
            }
        }
    }
}