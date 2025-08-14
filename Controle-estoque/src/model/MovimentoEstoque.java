import java.util.Date;
//import model.Produto; 

public abstract class MovimentoEstoque {
    // Atributos comuns a todos os movimentos
    private int id;
    private Date data;
    private Produto produto;
    private int quantidade;

    // Construtor que as classes filhas usarão
    public MovimentoEstoque(int id, Date data, Produto produto, int quantidade) {
        this.id = id;
        this.data = data;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    // Método abstrato que cada subclasse deve implementar
    public abstract void processarMovimento();

    // Getters para os atributos
    public int getId() {
        return id;
    }

    public Date getData() {
        return data;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }
}