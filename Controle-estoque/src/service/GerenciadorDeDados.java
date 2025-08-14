package service;

//import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date; // para os objetos de movimento

public class GerenciadorDeDados {
    private List<Produto> produtos;
    private List<Fornecedor> fornecedores;
    private List<Categoria> categorias;
    private List<MovimentoEstoque> historicoDeMovimentos;

    public GerenciadorDeDados() {
        this.produtos = new ArrayList<>();
        this.fornecedores = new ArrayList<>();
        this.categorias = new ArrayList<>();
        this.historicoDeMovimentos = new ArrayList<>();
    }

    // --- Métodos de Operações de CRUD para Produto ---
    public void cadastrarProduto(Produto novoProduto) {
        novoProduto.cadastrar();
        this.produtos.add(novoProduto);
    }
    public Produto consultarProduto(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }
    public void atualizarProduto(int id, Produto dadosAtualizados) {
        Produto produtoParaAtualizar = consultarProduto(id);
        if (produtoParaAtualizar != null) {
            // Chama a validação e copia os dados
            dadosAtualizados.atualizar();
            produtoParaAtualizar.setNome(dadosAtualizados.getNome());
            produtoParaAtualizar.setEstoqueMinimo(dadosAtualizados.getEstoqueMinimo());
            produtoParaAtualizar.setCategoria(dadosAtualizados.getCategoria());
            System.out.println("Produto atualizado.");
            // Nota: a lista de fornecimentos é gerenciada separadamente
        }
    }
    public void removerProduto(int id) {
        Produto produtoParaRemover = consultarProduto(id);
        if (produtoParaRemover != null) {
            produtoParaRemover.remover();
            this.produtos.remove(produtoParaRemover);
            System.out.println("Produto removido.");
        }
    }
    
    // --- Métodos de Operações de CRUD para Fornecedor ---
    public void cadastrarFornecedor(Fornecedor novoFornecedor) {
        novoFornecedor.cadastrar();
        this.fornecedores.add(novoFornecedor);
    }
    public Fornecedor consultarFornecedor(int id) {
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getId() == id) {
                return fornecedor;
            }
        }
        return null;
    }
    public void atualizarFornecedor(int id, Fornecedor dadosAtualizados) {
        Fornecedor fornecedorParaAtualizar = consultarFornecedor(id);
        if (fornecedorParaAtualizar != null) {
            fornecedorParaAtualizar.setNome(dadosAtualizados.getNome());
        }
    }
    public void removerFornecedor(int id) {
        Fornecedor fornecedorParaRemover = consultarFornecedor(id);
        if (fornecedorParaRemover != null) {
            fornecedorParaRemover.remover();
            this.fornecedores.remove(fornecedorParaRemover);
        }
    }
    
    // --- Métodos de Operações de CRUD para Categoria ---
    public void cadastrarCategoria(Categoria novaCategoria) {
        novaCategoria.cadastrar();
        this.categorias.add(novaCategoria);
    }
    public Categoria consultarCategoria(int id) {
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                return categoria;
            }
        }
        return null;
    }
    public void atualizarCategoria(int id, Categoria dadosAtualizados) {
        Categoria categoriaParaAtualizar = consultarCategoria(id);
        if (categoriaParaAtualizar != null) {
            categoriaParaAtualizar.setNome(dadosAtualizados.getNome());
        }
    }
    public void removerCategoria(int id) {
        Categoria categoriaParaRemover = consultarCategoria(id);
        if (categoriaParaRemover != null) {
            this.categorias.remove(categoriaParaRemover);
        }
    }
    
    // --- Métodos de Operações de Movimento de Estoque ---
    public void registrarEntrada(EntradaEstoque entrada) {
        this.historicoDeMovimentos.add(entrada);
        entrada.processarMovimento();
    }
    public void registrarSaida(SaidaEstoque saida) {
        this.historicoDeMovimentos.add(saida);
        saida.processarMovimento();
    }
    
    // --- Métodos de Relatórios e Consultas ---
    public int getTotalDeItensPorCategoria(String nomeCategoria) {
        int total = 0;
        for (Produto produto : produtos) {
            if (produto.getCategoria().getNome().equalsIgnoreCase(nomeCategoria)) {
                total += produto.getEstoqueAtual();
            }
        }
        return total;
    }
    public int getTotalDeItens(String nomeCategoria, String nomeFornecedor) {
        int total = 0;
        for (Produto produto : produtos) {
            if (produto.getCategoria().getNome().equalsIgnoreCase(nomeCategoria)) {
                for (Fornecimento forn : produto.getFornecimentos()) {
                    if (forn.getFornecedor().getNome().equalsIgnoreCase(nomeFornecedor)) {
                        // Não dá para saber a quantidade exata, então vamos somar o estoque do produto
                        total += produto.getEstoqueAtual();
                        break; // Para não contar o mesmo produto mais de uma vez
                    }
                }
            }
        }
        return total;
    }
    public List<Produto> gerarAlertaDeEstoqueMinimo() {
        List<Produto> produtosComEstoqueBaixo = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.verificarEstoqueMinimo()) {
                produtosComEstoqueBaixo.add(produto);
            }
        }
        return produtosComEstoqueBaixo;
    }
    public double getPrecoDeVenda(Produto produto, Fornecedor fornecedor) {
        for (Fornecimento fornecimento : produto.getFornecimentos()) {
            if (fornecimento.getFornecedor().equals(fornecedor)) {
                return fornecimento.getPrecoVenda();
            }
        }
        throw new IllegalArgumentException("Fornecedor não associado a este produto.");
    }

    public void adicionarOuAtualizarFornecimento(Produto produto, Fornecimento novoForn) {
        List<Fornecimento> fornecimentos = produto.getFornecimentos();
        for (Fornecimento fornecimento : fornecimentos) {
            if (fornecimento.getFornecedor().equals(novoForn.getFornecedor())) {
                fornecimento.setPrecoCusto(novoForn.getPrecoCusto());
                fornecimento.setPrecoVenda(novoForn.getPrecoVenda());
                return;
            }
        }
        fornecimentos.add(novoForn);
    }

    public List<Produto> listarProdutos() { return produtos; }
    public List<Fornecedor> listarFornecedores() { return fornecedores; }
    public List<Categoria> listarCategorias() { return categorias; }
}
