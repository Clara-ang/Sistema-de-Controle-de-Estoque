package model;

public class Categoria extends Usuario{
    private String nome;
    private String descricao;

    public Categoria(int id, String nome) {
        super(id);
        this.nome = nome;
    }

    public Categoria(int id, String nome, String descricao) {
        super(id);
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public String toString() {
        return "Categoria{id=" + id + ", nome='" + nome + "'}";
    }
}
