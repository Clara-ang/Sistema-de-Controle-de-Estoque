package model;

public abstract class Usuario{
    private int id;

    public Usuario(int id) {
        this.id = id;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
}
