package service;

import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class EstoqueService {
    private List<Produto> produtos = new ArrayList<>();

    public void cadastrarProduto(Produto produto) {
        if (produto.validar()) {
            produtos.add(produto);
        } else {
            System.out.println("Produto inválido!");
        }
    }

    public void entradaProduto(int id, int quantidade) throws Exception {
        Produto p = buscarProduto(id);
        if (p != null) p.adicionarEstoque(quantidade);
    }

    public void saidaProduto(int id, int quantidade) throws Exception {
        Produto p = buscarProduto(id);
        if (p != null) p.removerEstoque(quantidade);
    }

    public Produto buscarProduto(int id) {
        return produtos.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public List<Produto> listarProdutos() { return produtos; }

    public List<Produto> listarEstoqueBaixo() {
        List<Produto> alerta = new ArrayList<>();
        for (Produto p : produtos) {
            if (p.precisaReposicao()) alerta.add(p);
        }
        return alerta;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
