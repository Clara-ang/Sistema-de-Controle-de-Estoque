package model;

public class Fornecimento {
    private Produto produto;
    private Fornecedor fornecedor;

    public Fornecimento(Produto produto, Fornecedor fornecedor) {
        this.produto = produto;
        this.fornecedor = fornecedor;
    }

    public Produto getProduto() { return produto; }
    public Fornecedor getFornecedor() { return fornecedor; }

    @Override
    public String toString() {
        return "Fornecimento{produtoId=" + (produto != null ? produto.getId() : "null") +
               ", fornecedorId=" + (fornecedor != null ? fornecedor.getId() : "null") + "}";
    }
}
