public class Categoria implements Gerenciavel {

    private int id;
    private String nome;

    // Construtor
    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    
    // Implementação dos métodos da interface Gerenciavel
    @Override
    public void cadastrar() {
        System.out.println("Categoria " + nome + " cadastrada.");
    }

    @Override
    public void atualizar() {
        System.out.println("Categoria " + nome + " atualizada.");
    }

    @Override
    public void remover() {
        System.out.println("Categoria " + nome + " removida.");
    }
    
   
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
}