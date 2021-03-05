package modelos;

import java.util.Date;

public class EstoqueEntrada extends Estoque {

    private String dataEntrada;

    public EstoqueEntrada() {
    }
    
    public EstoqueEntrada(Produto produto, int quantidade, String dataEntrada) {
        super(produto, quantidade);
        this.dataEntrada = dataEntrada;
    }

    public EstoqueEntrada(String produto, String quantidade, String dataEntrada) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(String dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

}
