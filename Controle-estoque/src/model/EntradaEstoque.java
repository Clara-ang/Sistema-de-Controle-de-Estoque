package model;

import java.util.Date;

public class EntradaEstoque {
    private Date data;
    private Produto produto;
    private int quantidade;
    private Fornecedor fornecedor;

    public EntradaEstoque(Date data, Produto produto, int quantidade, Fornecedor fornecedor) {
        this.data = data;
        this.produto = produto;
        this.quantidade = quantidade;
        this.fornecedor = fornecedor;
    }

    public Date getData() { return data; }
    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
    public Fornecedor getFornecedor() { return fornecedor; }

    @Override
    public String toString() {
        return "EntradaEstoque{data=" + data + ", produtoId=" + (produto != null ? produto.getId() : "N/A")
                + ", qtd=" + quantidade + ", fornecedor=" + (fornecedor != null ? fornecedor.getNome() : "N/A") + "}";
    }
}
