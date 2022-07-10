package model;
public class Cliente extends Usuario implements Comparable<Cliente> {
	private String cpf;
	

	private ListaDeCompras listaDeCompras = new ListaDeCompras();
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf, String nomeUser, String senha){
		 this.nome = nome;
		 this.cpf = cpf;
		 this.nomeUser = nomeUser;
		 this.senha = senha;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
  

  	public ListaDeCompras getListaDeCompras() {
		return listaDeCompras;
	}

	public void setListaDeCompras(ListaDeCompras listaDeCompras) {
		this.listaDeCompras = listaDeCompras;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [cpf = ");
		builder.append(cpf);
		builder.append(", cartaoCredito = ");
		builder.append(", limiteCartao = ");
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Cliente cliente) {
		return this.nome.compareTo(cliente.getNome());
			
	}	
}
