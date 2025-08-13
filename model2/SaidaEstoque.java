import java.util.Date;

public class SaidaEstoque extends MovimentoEstoque {
    private String motivo;

    public SaidaEstoque(int id, Date data, Produto produto, int quantidade, String motivo) {
        super(id, data, produto, quantidade); // Chama o construtor da classe-mãe
        this.motivo = motivo;
    }

    // Implementação do método abstrato com tratamento de exceção
    @Override
    public void processarMovimento() {
        System.out.println("Processando saída do produto " + getProduto().getNome());
        try {
            getProduto().diminuirEstoque(getQuantidade());
            System.out.println("Estoque atualizado para " + getProduto().getEstoqueAtual());
        } catch (IllegalArgumentException e) {
            System.err.println("ERRO: Falha ao processar saída. " + e.getMessage());
        }
    }

    // Getter específico
    public String getMotivo() {
        return motivo;
    }
}