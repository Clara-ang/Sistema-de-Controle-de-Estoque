package model;

public class Produto extends Usuario implements Validavel {
    private String nome;
    private Categoria categoria;   // agora alterável
    private Fornecedor fornecedor; // agora alterável
    private int quantidade;
    private int estoqueMinimo;

    public Produto(int id, String nome, Categoria categoria, Fornecedor fornecedor, int quantidade, int estoqueMinimo) {
        super(id);
        this.nome = nome;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
        this.estoqueMinimo = estoqueMinimo;
    }

    @Override
    public boolean validar() {
        return nome != null && !nome.isEmpty() && quantidade >= 0 && estoqueMinimo >= 0;
    }

    public void adicionarEstoque(int qtd) { quantidade += qtd; }

    public void removerEstoque(int qtd) throws Exception {
        if (quantidade - qtd < 0) throw new Exception("Estoque insuficiente!");
        quantidade -= qtd;
    }

    public boolean precisaReposicao() {
        return quantidade <= estoqueMinimo;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public Fornecedor getFornecedor() { return fornecedor; }
    public void setFornecedor(Fornecedor fornecedor) { this.fornecedor = fornecedor; }

    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }

    public int getEstoqueMinimo() { return estoqueMinimo; }
    public void setEstoqueMinimo(int estoqueMinimo) { this.estoqueMinimo = estoqueMinimo; }

    @Override
    public String toString() {
        return "Produto: " + nome +
               " | Categoria: " + (categoria != null ? categoria.getNome() : "N/A") +
               " | Fornecedor: " + (fornecedor != null ? fornecedor.getNome() : "N/A") +
               " | Estoque: " + quantidade +
               " | Mínimo: " + estoqueMinimo;
    }
}
