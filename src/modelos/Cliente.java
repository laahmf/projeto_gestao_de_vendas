package modelos;

import java.util.Date;

public class Cliente extends CadastroClienteFornecedor {

    private int IdCliente;
    private String rg;
    private String cpf;
    private String dataNascimento;
    
    public Cliente(String nome, String telefone, String email){
        super(telefone, nome, email);
    };

    public Cliente(int IdCliente, String nome, String telefone, String email, 
                    String rg, String cpf, String dataNascimento) {
        super(telefone, nome, email);
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.IdCliente = IdCliente;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public String getRg() {
        return rg;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return super.getNome();
    }

  

}
