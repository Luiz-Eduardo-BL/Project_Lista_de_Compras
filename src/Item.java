import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Item {
  private int numProduto;
  private String nomeProduto;
  private float precoUnitario;
  private int quantidade;
  private float precoTotal;
  private float desconto;

  public Item() {
	  
  }
  
  public Item(int numProduto, String nomeProduto, float precoUnitario, int quantidade) {
    this.numProduto = numProduto;
    this.nomeProduto = nomeProduto;
    this.quantidade = quantidade;
    this.precoUnitario = precoUnitario;
    calcularPrecoTotal();
    calcularDesconto();
  }

  public Item(String nomeCliente, String nomeProduto2, int quantidade2) {
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
  }

  //Deconto maximo pode ser de 30%
  //se o valor total for maior q 100,00, o desconto maximo e de 10%
  //se o valor total for maior q 200,00, o desconto maximo e de 20%
  //se o valor total for maior q 300,00, o desconto maximo e de 30%
  public void calcularDesconto() {
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

  static List<Item> readListItensDeposito() {
	  List<Item> itens = new ArrayList<Item>();
      // use try-with-resources to ensure file is closed safely
      try (
              /* create a FileReader object that handles the low-level 
              details of reading the list from the "Cars.txt" file */
              FileReader itensFile = new FileReader("itensDepositoFile.txt");
              /* now create a BufferedReader object to wrap around carFile
              this allows us to user high-level functions such as readLine */
              BufferedReader itensStream = new BufferedReader(itensFile);
          )
      {
          // read the first line of the file
    	  String aux = itensStream.readLine();
          String itensFields[] = aux != null? aux.split(";") : null;
          while(itensFields != null) { // a null string indicates end of file
          	itens.add(new Item(Integer.parseInt(itensFields[0]), itensFields[1], 
          			Float.parseFloat(itensFields[2]), Integer.parseInt(itensFields[3])));
          	aux = itensStream.readLine();
          	itensFields = aux != null? aux.split(";") : null;
          }
      }
      catch(FileNotFoundException e) {
          System.out.println("\nerror: No file was read");
      }
      catch(IOException e) {
          System.out.println("\nerror: There was a problem reading the file");
      }
      
      return itens;
  }
  
  static void writeList(List<Item> itensDeposito) {
		// use try-with-resources to ensure file is closed safely
		try (
				/* create a FileWriter object, carFile, that handles
				the low-level details of writing the list to a file 
				which we have called "Cars.txt" */
				FileWriter itensFile = new FileWriter("itensDepositoFile.txt");
				/* now create a PrintWriter object to wrap around carFile;
				this allows us to user high-level functions such as println */
				PrintWriter itemWriter = new PrintWriter(itensFile);
			)
		{   
			String numProduto;
			String nomeProduto;
			String precoUnitario;
			String quantidade;
			for (Item item : itensDeposito) {
				numProduto = Integer.toString(item.getNumProduto());
				nomeProduto = item.getNomeProduto();
				precoUnitario = Float.toString(item.getPrecoUnitario());
				quantidade = Integer.toString(item.getQuantidade());
				itemWriter.print(String.format("%s;%s;%s;%s\n", 
						numProduto, nomeProduto, precoUnitario, quantidade));
			}
			
		}
		catch(IOException e) {
			System.out.println("There was a problem writing the file");
		}
  }
  @Override
  public String toString() {
    //Mostrar nome do produto, quantidade, preco unitario, preco total, desconto, preco total com desconto
    StringBuilder sb = new StringBuilder();
    sb.append("Nome do produto: " + this.nomeProduto + "\n");
    sb.append("Quantidade: " + this.quantidade + "\n");
    sb.append("Preco unitario: " + this.precoUnitario + "\n");
    sb.append("Preco total: " + this.precoTotal + "\n");
    sb.append("Desconto: " + this.desconto + "\n");
    sb.append("Preco total com desconto: " + this.precoTotal + "\n");
    return sb.toString();
  }

}
