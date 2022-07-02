package model;
public class Cliente extends Usuario{
	private String cpf;
	private String cartaoCredito;
	private float limiteDisponivelCartao;
	private ListaDeCompras listaDeCompras = new ListaDeCompras();
	
	public Cliente() {
	}
	
	public Cliente(String nome, String cpf, String cartaoCredito, 
			float limiteDisponivelCartao, String nomeUser, String senha){
		 this.nome = nome;
		 this.cpf = cpf;
		 this.cartaoCredito = cartaoCredito;
		 this.nomeUser = nomeUser;
		 this.senha = senha;
		 this.limiteDisponivelCartao = limiteDisponivelCartao;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCartaoCredito() {
		return cartaoCredito;
	}
	
	public void setLimiteDisponivelCartao(float limiteDisponivelCartao) {
		this.limiteDisponivelCartao = limiteDisponivelCartao;
	}
	
  	public float getLimiteDisponivelCartao() {
		return limiteDisponivelCartao;
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
		builder.append(cartaoCredito);
		builder.append(", limiteCartao = ");
		builder.append(limiteDisponivelCartao);
		builder.append("]");
		return builder.toString();
	}
	

	
}
