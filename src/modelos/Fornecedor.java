package modelos;

public class Fornecedor extends CadastroClienteFornecedor {

	private int idFornecedor;
	private String cnpj;
        
        public Fornecedor(){}
        
        public Fornecedor(String nome, String telefone, String email){
            super(nome, telefone, email);
        }

	public Fornecedor(String telefone, String nome, String email, String cnpj) {
		super(telefone, nome, email);
		this.cnpj = cnpj;
	}	

	public Fornecedor(int idFornecedor, String telefone, String nome, String email, String cnpj) {
		super(telefone, nome, email);
                this.idFornecedor = idFornecedor;
		this.cnpj = cnpj;
	}
	public int getIdFornecedor() {
		return idFornecedor;
	}

	public String getCnpj() {
		return cnpj;
	}
	public void SetIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public void SetCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

        @Override
        public String toString() {
            return cnpj + " - " + super.getNome();
        }

        
}