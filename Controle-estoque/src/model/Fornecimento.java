package model; 

//import model.Fornecedor;
//import model.Produto;

public class Fornecimento {
    private Fornecedor fornecedor;
    private Produto produto;
    private double precoCusto;
    private double precoVenda;

    // Construtor 
    public Fornecimento(Fornecedor fornecedor, Produto produto, double precoCusto, double precoVenda) {
        this.fornecedor = fornecedor;
        this.produto = produto;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    // Getters e Setters
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }
    
    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }
    
    // Para facilitar a exibição
    @Override
    public String toString() {
        return "Fornecimento{" +
               "fornecedor=" + fornecedor.getNome() +
               ", produto=" + produto.getNome() +
               ", precoCusto=" + precoCusto +
               ", precoVenda=" + precoVenda +
               '}';
    }
}