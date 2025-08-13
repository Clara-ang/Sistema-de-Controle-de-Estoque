import java.util.Date;

public class EntradaEstoque extends MovimentoEstoque {
    // Atributo específico para entrada
    private Fornecedor fornecedor;

    public EntradaEstoque(int id, Date data, Produto produto, int quantidade, Fornecedor fornecedor) {
        super(id, data, produto, quantidade); // Chama o construtor da classe-mãe
        this.fornecedor = fornecedor;
    }

    // Implementação do método abstrato
    @Override
    public void processarMovimento() {
        System.out.println("Processando entrada do produto " + getProduto().getNome());
        getProduto().aumentarEstoque(getQuantidade());
        System.out.println("Estoque atualizado para " + getProduto().getEstoqueAtual());
    }

    // Getter específico
    public Fornecedor getFornecedor() {
        return fornecedor;
    }
}