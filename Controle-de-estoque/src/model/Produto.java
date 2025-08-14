package model;

import java.util.List;
import java.util.ArrayList;

public class Produto implements Gerenciavel {
    private int id;
    private String nome;
    private int estoqueAtual;
    private int estoqueMinimo;
    private Categoria categoria;
    private List<Fornecimento> fornecimentos;

    public Produto(int id, String nome, int estoqueMinimo, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.estoqueMinimo = estoqueMinimo;
        this.categoria = categoria;
        this.estoqueAtual = 0; 
        this.fornecimentos = new ArrayList<>();
    }
    
    // Implementação dos métodos da interface Gerenciavel
    @Override
    public void cadastrar() {
        if (this.nome == null || this.nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
        System.out.println("Produto " + nome + " pronto para ser adicionado.");
    }
    
    @Override
    public void atualizar() {
        if (this.nome == null || this.nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
        System.out.println("Produto " + nome + " pronto para ser atualizado.");
    }
    
    @Override
    public void remover() {
        if (this.estoqueAtual > 0) {
            throw new IllegalStateException("Não é possível remover o produto. O estoque não está zerado.");
        }
        System.out.println("Produto " + nome + " pronto para ser removido.");
    }
    
    // Comportamento
    public void aumentarEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade a ser adicionada deve ser maior que zero.");
        }
        this.estoqueAtual += quantidade;
    }
    
    public void diminuirEstoque(int quantidade) throws IllegalArgumentException {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade a ser diminuida deve ser maior que zero.");
        }
        if (quantidade > estoqueAtual) {
            throw new IllegalArgumentException("Quantidade a ser retirada é maior que o estoque atual.");
        }
        this.estoqueAtual -= quantidade;
    }

    public boolean verificarEstoqueMinimo() {
        return this.estoqueAtual <= this.estoqueMinimo;
    }
    
    // Getters e Setters
    public int getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getEstoqueAtual() { return estoqueAtual; }
    public int getEstoqueMinimo() { return estoqueMinimo; }
    public void setEstoqueMinimo(int estoqueMinimo) { this.estoqueMinimo = estoqueMinimo; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public List<Fornecimento> getFornecimentos() { return fornecimentos; }
    public void setFornecimentos(List<Fornecimento> fornecimentos) { this.fornecimentos = fornecimentos; }
}