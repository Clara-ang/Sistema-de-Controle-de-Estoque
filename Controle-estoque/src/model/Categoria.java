// package model;

public class Categoria implements Gerenciavel {

    private int id;
    private String nome;

    // Construtor
    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Implementação dos métodos da interface Gerenciavel
     @Override
    public void cadastrar() {
        if (this.nome == null || this.nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da categoria não pode ser vazio.");
        }
        System.out.println("Categoria " + nome + " cadastrada.");
     }

    @Override
    public void atualizar() {
        if (this.nome == null || this.nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da categoria não pode ser vazio.");
        }
        System.out.println("Categoria " + nome + " atualizada.");
    }

    @Override
    public void remover() {
        System.out.println("Categoria " + nome + " removida.");
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}