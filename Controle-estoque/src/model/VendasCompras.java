package model;

public abstract class VendasCompras extends Usuario{
    protected String nome;

    public VendasCompras(int id, String nome) {
        super(id);
        this.nome = nome;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
