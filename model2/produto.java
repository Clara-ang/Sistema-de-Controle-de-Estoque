import java.util.List;
import java.util.ArrayList;

public class Produto {
    private int id;
    private String nome;
    private int estoqueAtual;
    private int estoqueMinimo;
    private Categoria categoria;
    private List<Fornecimento> fornecimentos;

    public Produto(int id, String nome, int estoqueMinimo, Categoria categoria) { // Construtor
        this.id = id;
        this.nome = nome;
        this.estoqueMinimo = estoqueMinimo;
        this.categoria = categoria;
        this.estoqueAtual = 0; 
        this.fornecimentos = new ArrayList<>(); // Inicializa a lista de fornecimentos
    }
    
    // COMPORTAMENTO
    public void aumentarEstoque(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade a ser adicionada deve ser maior que zero.");
        }
        this.estoqueAtual += quantidade;
    }
    
    public void diminuirEstoque(int quantidade) throws IllegalArgumentException { //Tratamento de exceções
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
    } // atualizar o texto
    
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
    
    public int getEstoqueAtual() {
        return estoqueAtual;
    }
    
    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }
    
    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }
    
    public Categoria getCategoria() {
        return categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    public List<Fornecimento> getFornecimentos() {
        return fornecimentos;
    }
    
    public void setFornecimentos(List<Fornecimento> fornecimentos) {
        this.fornecimentos = fornecimentos;
    }
}