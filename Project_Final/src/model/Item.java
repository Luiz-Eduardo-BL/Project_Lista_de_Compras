package model;

public class Item {
	private int numProduto;
	private String nomeProduto;
	private float precoUnitario;
	private int quantidade;
	private float precoTotal;
	private float desconto;
  
  	public Item(int numProduto, String nomeProduto, float precoUnitario, int quantidade) {
  		this.numProduto = numProduto;
  		this.nomeProduto = nomeProduto;
  		this.quantidade = quantidade;
  		this.precoUnitario = precoUnitario;
  		calcularPrecoTotal();
  	}

  	public int getNumProduto() {
  		return numProduto;
  	}

  	public void setNumProduto(int numProduto) {
  		this.numProduto = numProduto;
  	}

  	public String getNomeProduto() {
  		return nomeProduto;
  	}

  	public void setNomeProduto(String nomeProduto) {
  		this.nomeProduto = nomeProduto;
  	}

  	public int getQuantidade() {
  		return quantidade;
  	}

  	public void setQuantidade(int quantidade) {
  		this.quantidade = quantidade;
  		calcularPrecoTotal();
  	}

  	public float getPrecoUnitario() {
  		return precoUnitario;
  	}

  	public void setPrecoUnitario(float precoUnitario) {
  		this.precoUnitario = precoUnitario;
  	}

  	public float getPrecoTotal() {
  		return precoTotal;
  	}

  	public void setPrecoTotal(float precoTotal) {
  		this.precoTotal = precoTotal;
  	}

  	public float getDesconto() {
  		return desconto;
  	}

  	public void setDesconto(float desconto) {
  		this.desconto = desconto;
  	}

  	public void calcularPrecoTotal() {
  		this.precoTotal = this.quantidade * this.precoUnitario;
  		calcularDesconto();
  		precoTotal -= desconto;
  	}

  	//Deconto maximo pode ser de 30%
  	//se o valor total for maior q 100,00, o desconto maximo e de 10%
  	//se o valor total for maior q 200,00, o desconto maximo e de 20%
  	//se o valor total for maior q 300,00, o desconto maximo e de 30%
  	private void calcularDesconto() {
			//somar o valor de todos os itens da lista e ai aplicar o desconto
			
  		if (this.precoTotal > 100) {
  			this.desconto = this.precoTotal * 0.1f;
  		} else if (this.precoTotal > 200) {
  			this.desconto = this.precoTotal * 0.2f;
  		} else if (this.precoTotal > 300) {
  			this.desconto = this.precoTotal * 0.3f;
  		} else {
  			this.desconto = 0;
  		}
  	}

  	public void calcularPrecoTotalComDesconto() {
  		this.precoTotal = this.precoTotal - this.desconto;
  	}
  
  	@Override
  	public String toString() {
  		//Mostrar nome do produto, quantidade, preco unitario, preco total, desconto, preco total com desconto
  		StringBuilder sb = new StringBuilder();
    
  		sb.append(String.format("%-14s", nomeProduto));
  		sb.append(String.format("%-14s", quantidade));
  		sb.append(String.format("%-14s", precoUnitario));
  		sb.append(String.format("%-14s", desconto));
  		sb.append(String.format("%-14s", precoTotal));
  		return sb.toString();
  	}

}
