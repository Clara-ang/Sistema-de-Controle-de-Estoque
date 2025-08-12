package service;

import model.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EstoqueService {
    private List<Produto> produtos = new ArrayList<>();
    private List<Categoria> categorias = new ArrayList<>();
    private List<Fornecedor> fornecedores = new ArrayList<>();
    private List<EntradaEstoque> entradas = new ArrayList<>();
    private List<SaidaEstoque> saidas = new ArrayList<>();
    
    // Categoria
    public void adicionarCategoria(Categoria c) { categorias.add(c); }
    public void removerCategoria(int id) { categorias.removeIf(c -> c.getId() == id); }
    public Categoria buscarCategoria(int id) {
        for (Categoria c : categorias) if (c.getId() == id) return c;
        return null;
    }
    public List<Categoria> listarCategorias() { return categorias; }

    // Fornecedor
    public void adicionarFornecedor(Fornecedor f) { fornecedores.add(f); }
    public void removerFornecedor(int id) { fornecedores.removeIf(f -> f.getId() == id); }
    public Fornecedor buscarFornecedor(int id) {
        for (Fornecedor f : fornecedores) if (f.getId() == id) return f;
        return null;
    }
    public List<Fornecedor> listarFornecedores() { return fornecedores; }

    // Produto
    public void adicionarProduto(Produto p) { produtos.add(p); }
    public void removerProduto(int id) { produtos.removeIf(p -> p.getId() == id); }
    public Produto buscarProduto(int id) {
        for (Produto p : produtos) if (p.getId() == id) return p;
        return null;
    }
    public List<Produto> listarProdutos() { return produtos; }

    public void aumentarEstoque(int produtoId, int qtd, Fornecedor fornecedor) {
        Produto p = buscarProduto(produtoId);
        if (p == null) throw new IllegalArgumentException("Produto não encontrado");
        p.aumentarEstoque(qtd);
        // registra entrada
        entradas.add(new EntradaEstoque(new Date(), p, qtd, fornecedor));
        // vincula fornecedor ao produto (Fornecimento)
        if (fornecedor != null) p.adicionarFornecedor(new Fornecimento(p, fornecedor));
    }

    public void diminuirEstoque(int produtoId, int qtd, Fornecedor fornecedor) {
        Produto p = buscarProduto(produtoId);
        if (p == null) throw new IllegalArgumentException("Produto não encontrado");
        p.diminuirEstoque(qtd);
        saidas.add(new SaidaEstoque(new Date(), p, qtd, fornecedor));
    }

    public List<Produto> listarEstoqueBaixo() {
        List<Produto> res = new ArrayList<>();
        for (Produto p : produtos) if (p.verificarEstoqueMinimo()) res.add(p);
        return res;
    }

}
