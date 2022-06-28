import java.util.ArrayList;
import java.util.List;

public class ListaDeCompras {
	//listaDeItens sao uma lista de itens
	private List<Item> listaDeItens = new ArrayList<Item>();
	private float precoTotalLista;
	private static int numListaDeCompras;
  
	public ListaDeCompras() {
		numListaDeCompras++;
	}
   
  public String adicionarItem(String nomeProduto, int quantidade) {
	 List<Item> listaDeItensDesposito = Item.readListItensDeposito();
	 for (Item itemDeposito : listaDeItensDesposito) {
		 if(nomeProduto.equals(itemDeposito.getNomeProduto())) {
			 Item itemParaCarrinho = new Item(itemDeposito.getNumProduto(), 
					 						  itemDeposito.getNomeProduto(), 
					 						  itemDeposito.getPrecoUnitario(), 
					 						  quantidade);
			 itemDeposito.setQuantidade(itemDeposito.getQuantidade()-quantidade);
			 listaDeItens.add(itemParaCarrinho);
			 Item.writeList(listaDeItensDesposito);
			 return "Item adicionado com sucesso";
		 }	 
	 }
	 throw new MsgException("Produto nao esta no nosso deposito");  
  }

  	public String removerItem(String nomeProduto) {
  		for(int i = 0; i < listaDeItens.size(); i++) {
  			if(nomeProduto.equals(listaDeItens.get(i).getNomeProduto())) {
  				listaDeItens.remove(i);
  				return "Item removido com sucesso";
  			}
  		}		
  				 
		throw new MsgException("Produto nao esta no carrinho");
  }

  	public void atualizarQuantidade(String nomeProduto, int quantidade) {
  		for(int i = 0; i < listaDeItens.size(); i++) 
  			if(nomeProduto.equals(listaDeItens.get(i).getNomeProduto())) 
  				listaDeItens.get(i).setQuantidade(quantidade);
  		
		throw new MsgException("Produto nao esta no carrinho");
  	}

  	public void efetuarCompra() {
  		for (Item item : listaDeItens) {
  			item.setPrecoTotal(item.getPrecoUnitario() * item.getQuantidade());
  		}
  	}

  	public void cancelarCompra() {
  		//cancela a compra e remove os itens da listaDeCompras
  		listaDeItens.clear();
  }

  public float getPrecoTotalLista() {
    //paga a compra, ve o cartao do cliente, se tiver saldo paga, 
    if(listaDeItens.size() > 0) {
      for (Item item : listaDeItens) {
    	  precoTotalLista += item.getPrecoTotal();
      }
    }
    return precoTotalLista;
  }
  
  public String toString(){
	  StringBuilder sb = new StringBuilder();
	  sb.append(String.format("Item  %-14s%-14s%-14s%-14s%-14s\n", 
			  "Descricao", "Qtde.", "Vl.Uni", "Desconto", "ValorTotal"));
	  int cont = 0;
	  for(Item item : listaDeItens) {
		sb.append(String.format("[%03d] %s\n", cont, item));
		cont++;
	  }
	  
	  return sb.toString();
  }
  
}
