package modelos;

import java.util.ArrayList;

public class Produto {

    private int idProduto;
    private String nome;
    private int quantidade;
    private Categoria categoria;
    private Fornecedor fornecedor;
    private float preco;

    /**
     *
     */
    public Produto() {
    }
    
    public Produto(String nome, int quantidade, Categoria categoria, Fornecedor fornecedor, float preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.preco = preco;
    }
    
    public Produto(int idProduto, String nome, int quantidade, Categoria categoria, Fornecedor fornecedor, float preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.fornecedor = fornecedor;
        this.preco = preco;
    }
    public int getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdProduto(int IdProduto) {
        this.idProduto = IdProduto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}
