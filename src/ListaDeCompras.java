import java.util.List;

public class ListaDeCompras {
  //listaDeCompras é uma lista de itens
  private List<Item> listaDeCompras;
  private int numListaDeCompras;
  private int numProduto;
  private int quantidade;

  public List<Item> getListaDeCompras() {
    return listaDeCompras;
  }
  public void setListaDeCompras(List<Item> listaDeCompras) {
    this.listaDeCompras = listaDeCompras;
  }
  public int getNumListaDeCompras() {
    return numListaDeCompras;
  }
  public void setNumListaDeCompras(int numListaDeCompras) {
    this.numListaDeCompras = numListaDeCompras;
  }
  public int getNumProduto() {
    return numProduto;
  }
  public void setNumProduto(int numProduto) {
    this.numProduto = numProduto;
  }
  public int getQuantidade() {
    return quantidade;
  }
  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public ListaDeCompras(List<Item> listaDeCompras, int numListaDeCompras, int numProduto, int quantidade) {
    this.listaDeCompras = listaDeCompras;
    this.numListaDeCompras = numListaDeCompras;
    this.numProduto = numProduto;
    this.quantidade = quantidade;
  }
  
  public void adicionarItem(Item item) {
    listaDeCompras.add(item);
  }

  public void removerItem(Item item) {
    listaDeCompras.remove(item);
  }

  public void atualizarQuantidade(Item item, int quantidade) {
    item.setQuantidade(quantidade);
  }

  public void efetuarCompra() {
    for (Item item : listaDeCompras) {
      item.setPrecoTotal(item.getPrecoUnitario() * item.getQuantidade());
    }
  }

  public void cancelarCompra() {
    //cancela a compra e remove os itens da listaDeCompras
    listaDeCompras.clear();
  }

  public void pagarCompra() {
    //paga a compra, ve o cartao do cliente, se tiver saldo paga, 
    if(listaDeCompras.size() > 0) {
      for (Item item : listaDeCompras) {
        item.setPrecoTotal(item.getPrecoTotal() - (item.getPrecoTotal() * item.getDesconto()));
      }
    }
  }
}
