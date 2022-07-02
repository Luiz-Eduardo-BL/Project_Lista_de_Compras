package services;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/* 
 * system inclusions
 */
import model
.Item;
public class ServicesListeDeCompras {
	
	  public static void writeListItensDeposito(List<Item> itensDeposito) {
			try ( FileWriter itensFile = new FileWriter("src/arquivos/itensDepositoFile.txt");
					PrintWriter itemWriter = new PrintWriter(itensFile);)
			{   
				for (Item item : itensDeposito) 
					itemWriter.print(String.format("%s;%s;%s;%s\n", 
									 Integer.toString(item.getNumProduto()), 
									 item.getNomeProduto(),
									 Float.toString(item.getPrecoUnitario()), 
									 Integer.toString(item.getQuantidade())));
			}
			catch(IOException e) {
				System.out.println("There was a problem writing the file");
			}
	  }
	  
	  public static List<Item> readListItensDeposito() {
		  List<Item> itens = new ArrayList<Item>();
	      try ( FileReader itensFile = new FileReader("src/arquivos/itensDepositoFile.txt");
	              BufferedReader itensStream = new BufferedReader(itensFile);)
	      {
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
}
