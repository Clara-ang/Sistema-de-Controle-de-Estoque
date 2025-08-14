package model;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor implements Gerenciavel {
    private int id;
    private String nome;
    private List<Fornecimento> fornecimentos;

    public Fornecedor(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.fornecimentos = new ArrayList<>();
    }
    
    // Implementação dos métodos da interface Gerenciavel
    @Override
    public void cadastrar() {
        System.out.println("Fornecedor " + nome + " pronto para ser adicionado ao sistema.");
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