package model;

import java.util.ArrayList;
import java.util.List;

public class Produto extends Usuario {
    private String nome;
    private double precoCompra;
    private double precoVenda;
    private int estoqueAtual;
    private int estoqueMinimo;
    private Categoria categoria;
    // lista de fornecimentos (qual fornecedor fornece este produto)
    private List<Fornecimento> fornecedores = new ArrayList<>();

    public Produto(int id, String nome, double precoCompra, double precoVenda,
                   int estoqueAtual, int estoqueMinimo, Categoria categoria) {
        super(id);
        this.nome = nome;
        this.precoCompra = precoCompra;
        this.precoVenda = precoVenda;
        this.estoqueAtual = estoqueAtual;
        this.estoqueMinimo = estoqueMinimo;
        this.categoria = categoria;
    }

    // Getters e setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPrecoCompra() { return precoCompra; }
    public void setPrecoCompra(double precoCompra) { this.precoCompra = precoCompra; }

    public double getPrecoVenda() { return precoVenda; }
    public void setPrecoVenda(double precoVenda) { this.precoVenda = precoVenda; }
    public void atualizarPreco(double novoPreco) { setPrecoVenda(novoPreco); }

    public int getEstoqueAtual() { return estoqueAtual; }
    public void setEstoqueAtual(int estoqueAtual) { this.estoqueAtual = estoqueAtual; }

    public int getEstoqueMinimo() { return estoqueMinimo; }
    public void setEstoqueMinimo(int estoqueMinimo) { this.estoqueMinimo = estoqueMinimo; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public List<Fornecimento> getFornecedores() { return fornecedores; }

    // Fornecimento management
    public void adicionarFornecedor(Fornecimento f) {
        if (f != null && !fornecedores.contains(f)) fornecedores.add(f);
    }

    public void removerFornecedor(Fornecimento f) {
        fornecedores.remove(f);
    }

    public void mostrarDetalhes() {
        System.out.println(this.toString());
        if (!fornecedores.isEmpty()) {
            System.out.println("  Fornecedores:");
            for (Fornecimento f : fornecedores) {
                System.out.println("    - " + (f.getFornecedor() != null ? f.getFornecedor().getNome() : "N/A"));
            }
        }
    }

    // Estoque
    public void aumentarEstoque(int qtd) { this.estoqueAtual += qtd; }
    public void diminuirEstoque(int qtd) throws IllegalArgumentException {
        if (qtd > estoqueAtual) throw new IllegalArgumentException("Estoque insuficiente");
        this.estoqueAtual -= qtd;
    }

    public boolean verificarEstoqueMinimo() { return estoqueAtual <= estoqueMinimo; }

    @Override
    public String toString() {
        return "Produto{id=" + id +
               ", nome='" + nome + '\'' +
               ", precoCompra=" + precoCompra +
               ", precoVenda=" + precoVenda +
               ", estoqueAtual=" + estoqueAtual +
               ", estoqueMinimo=" + estoqueMinimo +
               ", categoria=" + (categoria != null ? categoria.getNome() : "N/A") +
               '}';
    }
}
