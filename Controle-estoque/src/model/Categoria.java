package model;

public class Categoria extends Usuario {
    private String nome;

    public Categoria(int id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() { 
        return nome; 
    }
    public void setNome(String nome) {
        this.nome = nome; 
    }

    @Override
    public String toString() {
        return "Categoria: " + nome;
    }
}

