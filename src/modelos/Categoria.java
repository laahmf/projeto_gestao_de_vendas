package modelos;

public class Categoria {

    private int idCategoria;
    private String nome;
    private String tipoCategoria;
    
    public Categoria(){};

    public Categoria(int idCategoria, String nome, String tipoCategoria) {
        this.idCategoria = idCategoria;
        this.nome = nome;
        this.tipoCategoria = tipoCategoria;
    }

    public String getNome() {
        return nome;
    }

    public String getTipoCategoria() {
        return tipoCategoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTipoCategoria(String tipoCategoria) {
        this.tipoCategoria = tipoCategoria;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return nome;
    }
    
    
    
    
    
}
