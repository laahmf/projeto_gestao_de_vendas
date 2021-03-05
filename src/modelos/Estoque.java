package modelos;

public class Estoque {

    private int idEstoque;
    private Produto produto;
    private int quantidade;
    
    public Estoque(){};

    public Estoque(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Estoque(int idEstoque, Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.idEstoque = idEstoque;
    }

    public int getIdEstoque() {
        return idEstoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setIdEstoque(int IdEstoque) {
        this.idEstoque = IdEstoque;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
