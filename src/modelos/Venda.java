package modelos;

import java.util.ArrayList;

public class Venda {
    
    private int idVenda;
    private String dataVenda;
    private Cliente cliente;
    private ArrayList<ItemVenda> itens;
    private float precoTotal;

    public Venda() {
    }
    
    public Venda(String dataVenda, Cliente cliente, ArrayList<ItemVenda> itens, float precoTotal) {
        this.dataVenda = dataVenda;
        this.cliente = cliente;
        this.itens = itens;
        this.precoTotal = precoTotal;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void SetCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ItemVenda> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemVenda> itens) {
        this.itens = itens;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(float precoTotal) {
        this.precoTotal = precoTotal;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
    
    
    
}
