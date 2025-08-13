import java.util.ArrayList;
import java.util.List;

public class Fornecedor implements Gerenciavel {
    private int id;
    private String nome;
    private List<Fornecimento> fornecimentos;

    // Construtor
    public Fornecedor(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.fornecimentos = new Arrayimport java.util.ArrayList;
import java.util.List;

public class GerenciadorDeDados {
    // Atributos que são as coleções para armazenar todos os objetos do sistema
    private List<Produto> produtos;
    private List<Fornecedor> fornecedores;
    private List<Categoria> categorias;
    private List<MovimentoEstoque> historicoDeMovimentos;

    // Construtor que inicializa todas as listas para evitar NullPointerException
    public GerenciadorDeDados() {
        this.produtos = new ArrayList<>();
        this.fornecedores = new ArrayList<>();
        this.categorias = new ArrayList<>();
        this.historicoDeMovimentos = new ArrayList<>();
    }

    // --- Métodos de Operações de CRUD para Produto ---

    public void cadastrarProduto(Produto novoProduto) {
        novoProduto.cadastrar(); // Validação do objeto
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
            produtoParaAtualizar.atualizar(); // Validação do objeto
            // Lógica para copiar dados de `dadosAtualizados` para `produtoParaAtualizar`
        }
    }

    public void removerProduto(int id) {
        Produto produtoParaRemover = consultarProduto(id);
        if (produtoParaRemover != null) {
            produtoParaRemover.remover(); // Validação do objeto
            this.produtos.remove(produtoParaRemover);
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
            fornecedorParaAtualizar.atualizar();
            // Lógica para copiar dados
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
        // Assume que Categoria tem métodos de Gerenciavel
        // novaCategoria.cadastrar(); 
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
        // Implementação similar a atualizarProduto
    }

    public void removerCategoria(int id) {
        Categoria categoriaParaRemover = consultarCategoria(id);
        if (categoriaParaRemover != null) {
            // Lógica de validação e remoção
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
            // Assume que Produto tem um método getFornecedor
            // if (produto.getCategoria().getNome().equalsIgnoreCase(nomeCategoria) &&
            //     produto.getFornecedor().getNome().equalsIgnoreCase(nomeFornecedor)) {
            //     total += produto.getEstoqueAtual();
            // }
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

    // --- Métodos de Persistência de Dados (Exemplo) ---

    public void salvarDados() {
        // Lógica para salvar as listas em um arquivo
    }

    public void carregarDados() {
        // Lógica para ler de um arquivo e carregar as listas
    }
}List<>();
    }
    
    // Implementação dos métodos da interface Gerenciavel
    // A lógica real estaria no GerenciadorDeDados
    @Override
    public void cadastrar() {
        if (this.nome == null || this.nome.trim().isEmpty()) {
        throw new IllegalArgumentException("O nome do fornecedor não pode ser vazio.");
    }
    System.out.println("Fornecedor " + nome + " pronto para ser adicionado ao sistema.");
}
    }
    
    @Override
    public void atualizar() {
        System.out.println("Dados do fornecedor " + nome + " atualizados.");
    }
    
    @Override
    public void remover() {
        System.out.println("Fornecedor " + nome + " removido.");
    }
    
    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Fornecimento> getFornecimentos() {
        return fornecimentos;
    }

    public void setFornecimentos(List<Fornecimento> fornecimentos) {
        this.fornecimentos = fornecimentos;
    }
}