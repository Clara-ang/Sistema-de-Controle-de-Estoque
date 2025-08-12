package model;

public class Fornecedor extends Usuario {
    private String nome;
    private String cnpj;
    private String contato;

    public Fornecedor(int id, String nome, String cnpj, String contato) {
        super(id);
        this.nome = nome;
        this.cnpj = cnpj;
        this.contato = contato;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }

    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }

    @Override
    public String toString() {
        return id + " - " + nome + " | CNPJ: " + cnpj + " | Contato: " + contato;
    }
}