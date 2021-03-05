package modelos;

import java.util.Date;

public class EstoqueSaida extends Estoque {

    private String dataSaida;
    private String motivoSaida;

    public EstoqueSaida() {}

    public EstoqueSaida(Produto produto, int quantidade, String dataSaida, String motivoSaida) {
        super(produto, quantidade);
        this.dataSaida = dataSaida;
        this.motivoSaida = motivoSaida;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getMotivoSaida() {
        return motivoSaida;
    }

    public void setMotivoSaida(String motivoSaida) {
        this.motivoSaida = motivoSaida;
    }

}
